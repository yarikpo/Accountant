package ua.clamor1s.Accountant.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.Accountant.dto.TransactionDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.entity.Transaction;
import ua.clamor1s.Accountant.repository.ProductRepository;
import ua.clamor1s.Accountant.repository.TransactionRepository;
import ua.clamor1s.Accountant.service.interfaces.TransactionService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static ua.clamor1s.Accountant.entity.enums.State.SOLD;
import static ua.clamor1s.Accountant.entity.enums.TransferType.SELL;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional
    public void createTransaction(TransactionDto transactionDto) {
        var transaction = setTransactionWithFields(transactionDto);
        if (transactionDto.transferType().toString().equals(SELL.toString())) {
            buyProduct(transaction.getProductId());
        }
        transactionRepository.save(transaction);
    }

    private void buyProduct(Product product) {
        product.setState(SOLD);
        product.setRetailPriceSell(getRetailPriceRightNow(product));
        productRepository.save(product);
    }


    private Double getRetailPriceRightNow(Product product) {
        int centValue = (int) (adjustValue(product.getPurchasePrice()) * 100);
        return centValue / 100.00;
    }

    private double adjustValue(double originalValue) {
        double rangePercentage = 0.05;
        double range = originalValue * rangePercentage;
        double randomOffset = Math.random() * 2 * range - range;
        double adjustedValue = originalValue + randomOffset;
        adjustedValue = Math.max(originalValue - range, Math.min(originalValue + range, adjustedValue));
        return adjustedValue;
    }


    private Transaction setTransactionWithFields(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID());
        transaction.setProductId(getProduct(transactionDto));
        transaction.setTransferType(transactionDto.transferType());
        transaction.setDate(LocalDate.now());
        transaction.setPrice(transactionDto.price());
        return transaction;
    }

    private Product getProduct(TransactionDto transactionDto) {
        return productRepository.findById(UUID.fromString(transactionDto.productId()))
                .orElse(null); // TODO throw ...
    }
}
