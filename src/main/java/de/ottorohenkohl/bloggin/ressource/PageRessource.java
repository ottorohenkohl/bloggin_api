package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.page.service.PageService;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.ExistingPage;
import de.ottorohenkohl.bloggin.domain.page.service.transfer.FreshPage;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/page")
@ApplicationScoped
public class PageRessource extends BaseRessource {
    
    @Inject
    protected PageService pageService;
    
    @Path("/{identifier}")
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getExistingPage(@PathParam("identifier") String identifier) {
        return Response.ok(pageService.findExistingPage(identifier)).build();
    }
    
    @Path("/")
    @PATCH
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response patchExistingPage(ExistingPage existingPage) {
        return Response.accepted(pageService.changeExistingPage(existingPage)).build();
    }
    
    @Path("/")
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response postFreshPage(FreshPage freshPage) {
        return Response.created(getPath("/page/%s", pageService.storeNewPage(freshPage).identifier())).build();
    }
    
    @Path("/{identifier}")
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response deleteExistingPage(@PathParam("identifier") String identifier) {
        return Response.created(getPath("/page/%s", pageService.removeExistingPage(identifier).identifier())).build();
    }
}