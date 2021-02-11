package com.leoncarraro.vaccination_control.service.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 7187672879930388402L;

    public BusinessException(String msg) {
        super(msg);
    }

}
