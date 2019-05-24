package com.boweihan.stattracker.service.exception.domain;

import com.boweihan.stattracker.service.exception.ApplicationServiceException;

import java.util.Collections;

public class MatchConflictException extends ApplicationServiceException {

    public MatchConflictException() {
        super("error.resource.conflict", 409, Collections.emptyList());
    }
}