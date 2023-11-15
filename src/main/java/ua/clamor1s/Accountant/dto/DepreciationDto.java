package ua.clamor1s.Accountant.dto;

import ua.clamor1s.Accountant.entity.Product;

public record DepreciationDto(
        Product product,
        Double depreciation
) {
}
