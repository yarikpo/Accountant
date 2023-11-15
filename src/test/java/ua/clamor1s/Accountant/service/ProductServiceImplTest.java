package ua.clamor1s.Accountant.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.entity.ProductType;
import ua.clamor1s.Accountant.repository.ProductRepository;
import ua.clamor1s.Accountant.repository.ProductTypeRepository;
import ua.clamor1s.Accountant.service.implementations.ProductServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static ua.clamor1s.Accountant.TestConstants.PRODUCT_UUID;
import static ua.clamor1s.Accountant.TestConstants.getProductWithId;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductTypeRepository productTypeRepository;

    @InjectMocks
    ProductServiceImpl productService;


    @Test
    void getAllByIdOk() {
        List<Product> expected = List.of(getProductWithId());
        when(productRepository.findAll()).thenReturn(List.of(getProductWithId()));

        List<Product> products = productService.getAll();
        Assertions.assertEquals(expected.size(), products.size());
    }

    @Test
    void createProductTest() {
        ProductDto productDto = new ProductDto(
                "name",
                PRODUCT_UUID.toString(),
                1000.00,
                1000.00
        );
        when(productTypeRepository.findById(UUID.fromString(productDto.typeId())))
                .thenReturn(Optional.of(new ProductType()));
        productService.createProduct(productDto);

        verify(productRepository, atLeastOnce()).save(any());
    }

//    Create other tests
}
