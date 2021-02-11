package com.leoncarraro.vaccination_control.controller.exception;

import com.leoncarraro.vaccination_control.service.exception.BadRequestException;
import com.leoncarraro.vaccination_control.service.exception.BusinessException;
import com.leoncarraro.vaccination_control.service.exception.ResourceAlreadyRegisteredException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<StandardError> methodArgumentNotValidExceptionHandler(
            MethodArgumentNotValidException e) {

        List<String> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        StandardError standardError = createError(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = {DateTimeParseException.class})
    public ResponseEntity<StandardError> dateTimeParseExceptionHandler() {
        List<String> errors = List.of("Date should be valid and follow DD/MM/YYYY pattern!");
        StandardError standardError = createError(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<StandardError> badRequestExceptionHandler(BadRequestException e) {
        List<String> errors = List.of(e.getMessage());
        StandardError standardError = createError(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<StandardError> businessExceptionHandler(BusinessException e) {
        List<String> errors = List.of(e.getMessage());
        StandardError standardError = createError(HttpStatus.BAD_REQUEST, errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);
    }

    @ExceptionHandler(value = {ResourceAlreadyRegisteredException.class})
    public ResponseEntity<StandardError> resourceAlreadyRegisteredExceptionHandler(
            ResourceAlreadyRegisteredException e) {
        List<String> errors = List.of(e.getMessage());
        StandardError standardError = createError(HttpStatus.CONFLICT, errors);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(standardError);
    }

    private StandardError createError(HttpStatus httpStatus, List<String> errors) {
        return new StandardError(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                new StandardError.Error(errors)
        );
    }

}
