package ua.clamor1s.Accountant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.clamor1s.Accountant.entity.Transaction;
import ua.clamor1s.Accountant.entity.enums.TransferType;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
