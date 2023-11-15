package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.TransactionDto;
import ua.clamor1s.Accountant.entity.Transaction;

import java.util.List;

public interface TransactionService {

    /**
     * receives all transactions
     * @return
     */
    List<Transaction> getAll();

    /**
     * creates transaction
     * if status is FIX -> checks if product not sold or utilized
     * if status is SELL -> checks status not SOLD already
     * @param transactionDto dto with transaction data
     */
    void createTransaction(TransactionDto transactionDto);

}
