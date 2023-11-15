package ua.clamor1s.Accountant.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import ua.clamor1s.Accountant.entity.enums.Period;

public record ProductTypeDto(
        @NotNull
        @Valid
        String name,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        @DecimalMax(value = "100.0", inclusive = true, message = "doubleValue must be less than or equal to 100.0")
        Double depreciationLimit,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        @DecimalMax(value = "100.0", inclusive = true, message = "doubleValue must be less than or equal to 100.0")
        Double depreciationSellRate,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        @DecimalMax(value = "100.0", inclusive = true, message = "doubleValue must be less than or equal to 100.0")
        Double depreciation,
        @NotNull
        Period depreciationPeriod,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = true, message = "doubleValue must be greater than or equal to 0.0")
        Double benefitRate,
        @NotNull
        Period benefitPeriod
) {
}
