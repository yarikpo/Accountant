package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.DepreciationDto;

import java.util.UUID;

public interface StatisticService {

    /**
     * TODO
     * @param productId
     * @return
     */
    DepreciationDto countProductDepreciation(UUID productId);

    /**
     * TODO
     * @return
     */
    Double countTotalIncome();
}
