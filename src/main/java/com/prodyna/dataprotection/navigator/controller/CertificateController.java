/*package com.prodyna.dataprotection.navigator.controller;

public class FeedbackController {
     post and produces json  input : Bewertung int,Kommentar string --- 200/201 ..badrequest



}*/

package com.prodyna.dataprotection.navigator.controller;

import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.ConfluenceUser;
import com.prodyna.dataprotection.navigator.model.CertificateAccessDTO;
import com.prodyna.dataprotection.navigator.service.CertificateAccessService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The controller class provides certificate endpoint.
 *
 * @see com.prodyna.dataprotection.navigator.service.CertificateAccessService
 */
@Produces({MediaType.APPLICATION_JSON})
@Path("certificate")
public class CertificateController {

    private final CertificateAccessService certificateAccessService;

    @Inject
    public CertificateController(CertificateAccessService certificateAccessService) {
        this.certificateAccessService = certificateAccessService;
    }

    /**
     * This endpoint is called, whenever a user tries to access the certificate.
     * Passes the required information to the service class for further analyses and
     * responds appropriately.
     *
     * @param levelId The level, for which the user wants to download the
     *                certificate. (Basis, Anwender, F\u00FChrungskr\u00E4fte)
     * @return 200. If the user is allowed to access the certificate otherwise 403.
     * @see com.prodyna.dataprotection.navigator.service.CertificateAccessService
     */
    @GET
    @Path("{id}")
    public Response getCertificate(@PathParam("id") int levelId) {
        ConfluenceUser confluenceUser = AuthenticatedUserThreadLocal.get();
        String userId = confluenceUser.getKey().toString();
        certificateAccessService.setUserAccessedCertificate(userId, levelId);
        return Response.ok().entity(new CertificateAccessDTO(confluenceUser.getFullName())).build();
    }
}
