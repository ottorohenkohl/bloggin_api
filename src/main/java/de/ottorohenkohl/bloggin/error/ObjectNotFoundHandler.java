package de.ottorohenkohl.bloggin.error;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.ObjectNotFoundException;

import java.util.HashMap;

@Provider
public class ObjectNotFoundHandler implements ExceptionMapper<ObjectNotFoundException> {
    
    @Override
    public Response toResponse(ObjectNotFoundException exception) {
        Log.debug("An error occurred: ", exception);
        
        var content = new HashMap<String, Object>();
        
        content.put("error", "Not Found");
        content.put("type", "Requested Resource is not available or does not exist");
        
        return Response.status(Response.Status.NOT_FOUND).entity(content).build();
    }
}