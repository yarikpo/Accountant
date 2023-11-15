package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    /**
     * TODO
     * @return
     */
    List<Product> getAll();

    /**
     * TODO
     * @param productDto
     */
    void createProduct(ProductDto productDto);
}
