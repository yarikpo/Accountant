package ua.clamor1s.Accountant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.clamor1s.Accountant.entity.Transaction;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
