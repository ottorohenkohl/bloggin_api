package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.global.service.GlobalService;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshConfig;
import de.ottorohenkohl.bloggin.domain.global.service.transfer.FreshMeta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/global")
@ApplicationScoped
public class GlobalRessource extends BaseRessource {
    
    @Inject
    protected GlobalService globalService;
    
    @Path(("/config"))
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getExistingConfig() {
        return Response.ok(globalService.findExistingConfig()).build();
    }
    
    @Path("/meta")
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response getExistingMeta() {
        return Response.ok(globalService.findExistingMeta()).build();
    }
    
    @Path("/config")
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response putFreshConfig(FreshConfig freshConfig) {
        return Response.created(getPath("/global/config",
                                        globalService.replaceExistingConfig(freshConfig).identifier())).build();
    }
    
    @Path("/meta")
    @PUT
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response putFreshMeta(FreshMeta freshMeta) {
        return Response.created(getPath("/global/meta", globalService.replaceExistingMeta(freshMeta).identifier()))
                       .build();
    }
}