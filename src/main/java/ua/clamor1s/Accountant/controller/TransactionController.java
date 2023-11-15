package ua.clamor1s.Accountant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.clamor1s.Accountant.dto.TransactionDto;
import ua.clamor1s.Accountant.entity.Transaction;
import ua.clamor1s.Accountant.service.interfaces.TransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
        return ResponseEntity.noContent().build();
    }

//    TODO update delete
}
