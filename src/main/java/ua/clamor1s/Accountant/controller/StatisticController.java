package ua.clamor1s.Accountant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.clamor1s.Accountant.dto.DepreciationDto;
import ua.clamor1s.Accountant.service.interfaces.StatisticService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/depreciation/{productId}")
    public DepreciationDto countProductDepreciation(@PathVariable UUID productId) {
        return statisticService.countProductDepreciation(productId);
    }

    @GetMapping("/total")
    public Double countTotalIncome() {
        return statisticService.countTotalIncome();
    }

}
