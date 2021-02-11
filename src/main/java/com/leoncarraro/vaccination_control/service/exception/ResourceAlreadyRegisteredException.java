package com.leoncarraro.vaccination_control.service.exception;

public class ResourceAlreadyRegisteredException extends RuntimeException {
    private static final long serialVersionUID = -475123285862064202L;

    public ResourceAlreadyRegisteredException(String msg) {
        super(msg);
    }

}
