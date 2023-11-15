package ua.clamor1s.Accountant.dto;

import jakarta.validation.constraints.NotNull;
import ua.clamor1s.Accountant.entity.enums.TransferType;

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
