package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.TransactionDto;
import ua.clamor1s.Accountant.entity.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {

    /**
     * TODO
     * @return
     */
    List<Transaction> getAll();

    /**
     * TODO
     * @param transactionDto
     */
    void createTransaction(TransactionDto transactionDto);

}
