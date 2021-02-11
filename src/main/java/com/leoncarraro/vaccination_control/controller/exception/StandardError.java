package com.leoncarraro.vaccination_control.controller.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class StandardError {

    static class Error {

        private final List<String> description;

        public Error(List<String> description) {
            this.description = description;
        }

        public List<String> getDescription() { return description; }

    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private final LocalDateTime timestamp;
    private final Integer httpStatusCode;
    private final String httpStatusDescription;
    private final Error errors;

    public StandardError(LocalDateTime timestamp, Integer httpStatusCode,
                         String httpStatusDescription, Error errors) {
        this.timestamp = timestamp;
        this.httpStatusCode = httpStatusCode;
        this.httpStatusDescription = httpStatusDescription;
        this.errors = errors;
    }

    public LocalDateTime getTimestamp() { return timestamp; }

    public Integer getHttpStatusCode() { return httpStatusCode; }

    public String getHttpStatusDescription() { return httpStatusDescription; }

    public Error getErrors() { return errors; }

}
