package de.ottorohenkohl.bloggin.error;

import io.quarkus.logging.Log;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.HashMap;
import java.util.Map;

@Provider
public class ConstraintViolationHandler implements ExceptionMapper<ConstraintViolationException> {
    
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Log.debug("An error occurred: ", exception);
        
        var violations = exception.getConstraintViolations().stream().map(this::toViolation).toList();
        var content = new HashMap<String, Object>();
        
        content.put("error", "Bad Request");
        content.put("type", "Constraint Violation");
        content.put("violations", violations);
        
        return Response.status(Response.Status.BAD_REQUEST).entity(content).build();
    }
    
    public Map<String, String> toViolation(ConstraintViolation<?> constraintViolation) {
        var violation = new HashMap<String, String>();
        
        violation.put("location", constraintViolation.getLeafBean().getClass().getSimpleName());
        violation.put("target", constraintViolation.getPropertyPath().toString());
        
        return violation;
    }
}