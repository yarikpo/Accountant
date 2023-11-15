package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;

import java.util.List;

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
