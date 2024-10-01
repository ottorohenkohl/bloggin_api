package de.ottorohenkohl.bloggin.ressource;

import de.ottorohenkohl.bloggin.domain.file.service.FileService;
import de.ottorohenkohl.bloggin.domain.file.service.transfer.FreshFile;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.WILDCARD;

@Path("/file")
@ApplicationScoped
public class FileRessource extends BaseRessource {
    
    @Inject
    protected FileService fileService;
    
    @Path("/{identifier}")
    @DELETE
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response deleteExistingFile(@PathParam("identifier") String identifier) {
        return Response.accepted(fileService.removeExistingFile(identifier)).build();
    }
    
    @Path("/{identifier}")
    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(WILDCARD)
    public Response getExistingFile(@PathParam("identifier") String identifier) {
        return Response.ok(fileService.findExistingFile(identifier).data()).build();
    }
    
    @Path("/")
    @POST
    @Consumes(WILDCARD)
    @Produces(APPLICATION_JSON)
    public Response postFreshFile(@Context HttpHeaders headers, InputStream inputStream) throws IOException {
        var newFile = new FreshFile(headers.getHeaderString("Content-Type"), inputStream.readAllBytes());
        
        return Response.created(getPath("/file/%s", fileService.storeNewFile(newFile).identifier())).build();
    }
}