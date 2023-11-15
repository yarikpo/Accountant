package ua.clamor1s.Accountant.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.clamor1s.Accountant.exception.ValidationErrorResponse;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @Nullable HttpHeaders headers, @Nullable HttpStatusCode status, @Nullable WebRequest request) {

        List<String> errors = new ArrayList<>(ex.getFieldErrorCount());
        for (var filedError : ex.getFieldErrors()) {
            errors.add(filedError.toString());
        }
        return new ResponseEntity<>(new ValidationErrorResponse(errors), BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintViolationException(ConstraintViolationException exception) {
        List<String> violations = new ArrayList<>(exception.getConstraintViolations().size());

        exception.getConstraintViolations()
                .forEach(v -> violations.add(v.getMessage()));
        return new ResponseEntity<>(new ValidationErrorResponse(violations), BAD_REQUEST);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleExpectedException(ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), ex.getStatusCode());
    }
}
