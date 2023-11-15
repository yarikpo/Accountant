package ua.clamor1s.Accountant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ua.clamor1s.Accountant.entity.enums.State;

import java.time.LocalDate;
import java.util.UUID;

public record ProductDto(
        @NotNull
        @Valid
        String name,
        @org.hibernate.validator.constraints.UUID
        @NotNull
        String typeId,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        Double purchasePrice,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        Double retailPriceBuy
) {
}
