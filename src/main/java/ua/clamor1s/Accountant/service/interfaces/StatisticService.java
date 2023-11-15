package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.DepreciationDto;

import java.util.UUID;

public interface StatisticService {

    /**
     * counts depreciation in per cents in one product by its id
     * @param productId id of product
     * @return dto with product and its depreciation
     */
    DepreciationDto countProductDepreciation(UUID productId);

    /**
     * counts total sum from positive transactions
     * @return value
     */
    Double countTotalIncome();
}
