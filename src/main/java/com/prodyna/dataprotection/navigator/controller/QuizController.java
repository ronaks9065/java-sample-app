/*package com.prodyna.dataprotection.navigator.controller;

public class FeedbackController {
     post and produces json  input : Bewertung int,Kommentar string --- 200/201 ..badrequest



}*/

package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.prodyna.dataprotection.navigator.converter.UserToUserDTOMapper;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.model.UserDTO;
import com.prodyna.dataprotection.navigator.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The Quiz controller class provides quizstarted and quizfinished endpoints.
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("quiz")
public class QuizController {

    private final UserService userService;
    private final UserToUserDTOMapper mapper;

    @Inject
    public QuizController(
            UserService userService,
            UserToUserDTOMapper mapper
    ) {
        this.userService = userService;
        this.mapper = mapper;
    }

    /**
     * This endpoint is called, whenever a user starts a Quiz.
     *
     * @param userQuizData consists of level id and quiz id.
     * @return 200, Returns the progress of the user
     * @see com.prodyna.dataprotection.navigator.model.UserDTO
     */
    @PUT
    @Path("quizStarted")
    public Response startQuizForUser(UserDTO userQuizData) {
        User user = userService.startQuizForUser(userQuizData, AuthenticatedUserThreadLocal.get());
        return Response.status(Response.Status.OK).entity(mapper.mapTo(user)).build();
    }

    /**
     * This endpoint is called, whenever a user finishes a Quiz.
     *
     * @param userQuizData consists of level id and quiz id.
     * @return 200, Returns the progress of the user
     * @see com.prodyna.dataprotection.navigator.model.UserDTO
     */
    @PUT
    @Path("quizFinished")
    public Response finishQuizForUser(UserDTO userQuizData) {
        User user = userService.finishQuizForUser(userQuizData, AuthenticatedUserThreadLocal.get());
        return Response.status(Response.Status.OK).entity(mapper.mapTo(user)).build();
    }
}
