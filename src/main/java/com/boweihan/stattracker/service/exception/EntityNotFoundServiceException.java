package com.boweihan.stattracker.service.exception;


import java.util.Collections;

public abstract class EntityNotFoundServiceException extends ApplicationServiceException {
    protected EntityNotFoundServiceException() {
        super("error.resource.not_found", 404, Collections.emptyList());
    }
}