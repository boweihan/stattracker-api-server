package com.boweihan.stattracker.service.exception;

import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class ApplicationServiceException extends RuntimeException {

    @NonNull
    private final String message;

    @NonNull
    private final int httpStatusCode;

    @NonNull
    private final List<?> parameters;

    protected ApplicationServiceException(String message, int httpStatusCode, List<?> parameters) {
        super(message);

        if (httpStatusCode < 400 || httpStatusCode > 499) {
            throw new IllegalArgumentException("Not a valid client error code.");
        }

        this.message = message;
        this.httpStatusCode = httpStatusCode;
        this.parameters = parameters == null ? Collections.emptyList() : parameters;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public List<?> getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationServiceException that = (ApplicationServiceException) o;
        return httpStatusCode == that.httpStatusCode &&
                Objects.equals(message, that.message) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, httpStatusCode, parameters);
    }

    @Override
    public String toString() {
        return "ApplicationServiceException{" +
                "type='" + getClass().getSimpleName() + '\'' +
                "message='" + message + '\'' +
                ", httpStatusCode=" + httpStatusCode +
                ", parameters=" + parameters +
                '}';
    }
}