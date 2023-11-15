package ua.clamor1s.Accountant.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.ProductType;
import ua.clamor1s.Accountant.repository.ProductTypeRepository;
import ua.clamor1s.Accountant.service.implementations.ProductTypeServiceImpl;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static ua.clamor1s.Accountant.TestConstants.getProductTypeWithId;

@ExtendWith(MockitoExtension.class)
public class ProductTypeServiceImplTest {

    @Mock
    ProductTypeRepository productTypeRepository;
    @InjectMocks
    ProductTypeServiceImpl productTypeService;

    @Test
    void getAllByIdOk() {
        List<ProductType> expected = List.of(getProductTypeWithId());
        when(productTypeRepository.findAll()).thenReturn(List.of(getProductTypeWithId()));

        List<ProductType> products = productTypeService.getAll();
        Assertions.assertEquals(expected.size(), products.size());
    }

    @Test
    void createProductTypeTest() {
        ProductTypeDto productTypeDto = new ProductTypeDto(
                "name",
                50.00,
                1000.00,
                1000.00,
                null,
                50.00,
                null
        );
        productTypeService.createProductType(productTypeDto);

        verify(productTypeRepository, atLeastOnce()).save(any());
    }

//    Create other tests
}
