package ua.clamor1s.Accountant.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ua.clamor1s.Accountant.entity.enums.State;

import java.time.LocalDate;
import java.util.UUID;

public record ProductDto(
        String name,
        UUID typeId,
        Double purchasePrice,
        Double retailPriceBuy
) {
}
