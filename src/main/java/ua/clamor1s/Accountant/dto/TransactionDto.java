package ua.clamor1s.Accountant.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ua.clamor1s.Accountant.entity.enums.TransferType;

import java.util.UUID;

public record TransactionDto(
        @NotNull
        @org.hibernate.validator.constraints.UUID
        String productId,
        @NotNull
        TransferType transferType,
        @NotNull
        Double price
) {
}
