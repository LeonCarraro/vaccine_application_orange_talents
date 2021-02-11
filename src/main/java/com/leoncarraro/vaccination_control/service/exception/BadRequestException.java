package com.leoncarraro.vaccination_control.service.exception;

public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = -2861552928251496378L;

    public BadRequestException(String msg) {
        super(msg);
    }

}
