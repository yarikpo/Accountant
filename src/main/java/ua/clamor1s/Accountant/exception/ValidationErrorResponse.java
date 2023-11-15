package ua.clamor1s.Accountant.exception;

import java.util.List;

public record ValidationErrorResponse(
        String errorCode,
        List<String> errorExtensions) {
    public ValidationErrorResponse(List<String> errorExtensions) {
        this("validation_failed", errorExtensions);
    }
}