package ua.clamor1s.Accountant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.clamor1s.Accountant.repository.ProductRepository;
import ua.clamor1s.Accountant.repository.TransactionRepository;
import ua.clamor1s.Accountant.service.implementations.StatisticServiceImpl;

@ExtendWith(MockitoExtension.class)
public class StatisticServiceTest {

    @Mock
    ProductRepository productRepository;
    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    @Spy
    StatisticServiceImpl statisticService;

    @Test
    void init() {

    }

//    TODO Create tests
}
