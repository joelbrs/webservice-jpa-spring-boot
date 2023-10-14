package br.com.joelbrs.jpawebservice.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not Found: Id " + id);
    }
}
