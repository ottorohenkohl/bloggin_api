package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.component.service.ComponentService;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.ExistingComponent;
import de.ottorohenkohl.bloggin.domain.component.service.transfer.FreshComponent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/component")
@ApplicationScoped
public class ComponentRessource extends BaseRessource {
    
    @Inject
    protected ComponentService componentService;
    
    @Path("/{identifier}")
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getExistingComponent(@PathParam("identifier") String identifier) {
        return Response.ok(componentService.findExistingComponent(identifier)).build();
    }
    
    @Path("/")
    @PATCH
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response patchExistingComponent(ExistingComponent existingComponent) {
        return Response.accepted(componentService.changeExistingComponent(existingComponent)).build();
    }
    
    @Path("/")
    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response postFreshComponent(FreshComponent freshComponent) {
        return Response.created(getPath("/component/%s", componentService.storeNewComponent(freshComponent).identifier())).build();
    }
    
    @Path("/{identifier}")
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response deleteExistingComponent(@PathParam("identifier") String identifier) {
        return Response.accepted(componentService.removeExistingComponent(identifier).identifier()).build();
    }
}