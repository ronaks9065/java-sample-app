package com.prodyna.dataprotection.navigator.service;

import com.atlassian.bandana.BandanaManager;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;
import com.atlassian.confluence.user.ConfluenceUser;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.prodyna.dataprotection.navigator.action.WelcomeAction;
import com.prodyna.dataprotection.navigator.model.*;
import com.prodyna.dataprotection.navigator.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * The service class for updating user information.
 */
@Named
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private static final String USERS = "Users_";

    private final BandanaManager bandanaManager;

    private final ConfluenceBandanaContext ctx = new ConfluenceBandanaContext(WelcomeAction.DPN_BANDANA_KEY);

    @Inject
    public UserService(@ComponentImport BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    /**
     * Gets a user by the user's confluence key. This id is hashed via SHA256 and encoded via Base64 before saving it
     * to Bandana and retrieving it
     *
     * @param id The user's confluence key
     * @return Returns a user fetched from Bandana or a new User when no user was found
     */
    public User getUserById(String id) {
        String hashedId = hashId(id);
        User user = getUserFromBandana(USERS + hashedId);
        if (user == null) {
            user = new User(hashedId);
        }
        updateBandanaUser(user);
        return user;
    }

    private User getUserFromBandana(String userKey) {
        try {
            String userString = (String) bandanaManager.getValue(ctx, userKey);
            return JsonUtils.fromJson(userString, User.class);
        } catch (Exception e) {
            return null;
        }
    }

    private String hashId(String id) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] idBytes = digest.digest(id.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(idBytes);
        } catch (Exception e) {
            /* Should not occur, as we pass in the Algorithm as Constant; */
        }
        return "";
    }

    /**
     * This method updates the user in Bandana.
     *
     * @param user The User
     */

    void updateBandanaUser(User user) {
        try {
            String userString = JsonUtils.toJson(user);
            bandanaManager.setValue(ctx, USERS + user.getUserId(), userString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods set the starting time for a user and updates the user information.
     *
     * @param userQuizData   A UserDTO to specify the quiz and level id.
     * @param confluenceUser A confluence user
     * @return the user after updating data.
     */
    public User startQuizForUser(UserDTO userQuizData, ConfluenceUser confluenceUser) {
        User user = getUserById(confluenceUser.getKey().toString());
        boolean found = false;
        for (QuizItem quiz : user.getQuizes()) {
            if (quiz.getLevelID() == userQuizData.getSelectedLevel() && quiz.getQuizID() == userQuizData.getIntQuizId()) {
                if (quiz.getFinishedTime() == null) {
                    quiz.setStartingTime(new Date());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            user.addQuiz(new QuizItem(userQuizData.getSelectedLevel(), userQuizData.getIntQuizId()));
        }
        updateBandanaUser(user);
        return user;
    }

    /**
     * Gets all users saved in Bandana.
     *
     * @return Returns all Users
     */
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        for (String key : bandanaManager.getKeys(ctx)) {
            if (key.startsWith(USERS)) {
                userList.add(getUserFromBandana(key));
            }
        }
        return userList;
    }

    /**
     * This method set the completion time of a quiz for the user.
     *
     * @param userQuizData   A UserDTO to specify the quiz and level id.
     * @param confluenceUser A confluence user
     * @return the user after updating data.
     */
    public User finishQuizForUser(UserDTO userQuizData, ConfluenceUser confluenceUser) {
        User user = getUserById(confluenceUser.getKey().toString());
        boolean found = false;
        for (QuizItem quiz : user.getQuizes()) {
            if (quiz.getLevelID() == userQuizData.getSelectedLevel() && quiz.getQuizID() == userQuizData.getIntQuizId()) {
                if (quiz.getFinishedTime() == null) {
                    quiz.setFinishedTime(new Date());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            LOGGER.warn("User finished Quiz which was not started");
        }
        updateBandanaUser(user);
        return user;
    }

    /**
     * Adds a new AccessEntry for the user. This includes a timestamp and a device
     *
     * @param userToUpdate A user.
     * @param deviceType   The deviceType of the user.
     */
    public void updateUser(User userToUpdate, DeviceType deviceType) {
        userToUpdate.addAccessEntry(new AccessEntry(new Date(), deviceType));
        updateBandanaUser(userToUpdate);
    }

    /**
     * Sets the user's feedback if not already set, otherwise do nothing
     *
     * @param feedback A feedback from user.
     * @param userId   A user id.
     */
    public User setFeedbackFromUser(Feedback feedback, String userId) {
        User user = getUserById(userId);
        if (user.getFeedback() == null) {
            user.setFeedback(feedback);
        }
        updateBandanaUser(user);
        return user;
    }
}
