package ua.clamor1s.Accountant.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.Accountant.dto.DepreciationDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.entity.Transaction;
import ua.clamor1s.Accountant.entity.enums.TransferType;
import ua.clamor1s.Accountant.repository.ProductRepository;
import ua.clamor1s.Accountant.repository.TransactionRepository;
import ua.clamor1s.Accountant.service.interfaces.StatisticService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StatisticServiceImpl implements StatisticService {

    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public DepreciationDto countProductDepreciation(UUID productId) {
        var product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new); // TODO throws....
        Double depreciation = Math.min(100.0, countDepreciationDueDate(product) + countDepreciationDueTransactions(product));
        return new DepreciationDto(product, depreciation);
    }

    @Override
    public Double countTotalIncome() {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getTransferType().equals(TransferType.SELL))
                .mapToDouble(Transaction::getPrice)
                .sum();
    }

    private Double countDepreciationDueDate(Product product) {
        var purchaseDate = product.getPurchaseBuyDate();
        var todaysDate = LocalDate.now();

        Long amountOfDepreciations = switch (product.getTypeId().getDepreciationPeriod()) {
            case DAY -> ChronoUnit.DAYS.between(purchaseDate, todaysDate);
            case MONTH -> ChronoUnit.MONTHS.between(purchaseDate, todaysDate);
            case YEAR -> ChronoUnit.YEARS.between(purchaseDate, todaysDate);
        };
        Double depreciationPerTime = product.getTypeId().getDepreciation();

        return depreciationPerTime * amountOfDepreciations;
    }

    private Double countDepreciationDueTransactions(Product product) {
        Double amountOfLostMoney = transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getProductId().getId().toString().equals(product.getId().toString()))
                .filter(transaction -> transaction.getTransferType().equals(TransferType.FIX))
                .mapToDouble(Transaction::getPrice)
                .sum();
        Double price = product.getPurchasePrice();
        return Math.abs(price / amountOfLostMoney);
    }
}
