/*package com.prodyna.dataprotection.navigator.controller;

public class FeedbackController {
     post and produces json  input : Bewertung int,Kommentar string --- 200/201 ..badrequest



}*/

package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.prodyna.dataprotection.navigator.model.Feedback;
import com.prodyna.dataprotection.navigator.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * The controller class provides Feedback endpoint.
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("feedback")
public class FeedbackController {

    private final UserService userService;

    @Inject
    public FeedbackController(UserService userService) {
        this.userService = userService;
    }


    /**
     * This endpoint is called, whenever a user gives a feedback
     *
     * @param feedback of the user, which has to be stored.
     * @return CREATED(201) / BAD_REQUEST if user does not exist.
     */
    @PUT
    public Response sendFeedback(Feedback feedback) {
        ConfluenceUser confluenceUser = AuthenticatedUserThreadLocal.get();
        if (feedback == null || confluenceUser == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        feedback.setDate(new Date());
        userService.setFeedbackFromUser(feedback, confluenceUser.getKey().toString());
        return Response.status(Response.Status.CREATED).build();
    }
}
