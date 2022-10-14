/*package com.prodyna.dataprotection.navigator.controller;

public class FeedbackController {
     post and produces json  input : Bewertung int,Kommentar string --- 200/201 ..badrequest



}*/

package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.prodyna.dataprotection.navigator.converter.UserToUserDTOMapper;
import com.prodyna.dataprotection.navigator.model.DeviceType;
import com.prodyna.dataprotection.navigator.model.User;
import com.prodyna.dataprotection.navigator.service.UserService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The controller class provides userProgress endpoint.
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Path("userProgress")
public class AccessController {


    private final UserService userService;
    private final UserToUserDTOMapper mapper;

    @Inject
    public AccessController(
            UserService userService,
            UserToUserDTOMapper mapper
    ) {
        this.userService = userService;
        this.mapper = mapper;
    }

    /**
     * This endpoint is called after each access of the user.
     * Passes the required information to the service class for Storing the user device and further analyses.
     *
     * @param request HttpServletRequest.
     * @param device  The Device type of the user. This could be Desktop, Tablet or Mobile.
     * @return 200. The user data.
     */
    @GET
    public Response getUserData(
            @Context HttpServletRequest request,
            @QueryParam("device") String device
    ) {
        ConfluenceUser confluenceUser = AuthenticatedUserThreadLocal.get();

        DeviceType deviceType = DeviceType.DESKTOP;
        if (device != null) {
            switch (device) {
                case "tablet":
                    deviceType = DeviceType.TABLET;
                    break;
                case "mobile":
                    deviceType = DeviceType.MOBILE;
                    break;
            }
        }

        User user = userService.getUserById(confluenceUser.getKey().toString());
        userService.updateUser(user, deviceType);
        return Response.status(Response.Status.OK).entity(mapper.mapTo(user)).build();
    }
}
