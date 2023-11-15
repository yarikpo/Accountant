package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;

import java.util.List;

public interface ProductService {

    /**
     * Receives all products
     * @return list of products
     */
    List<Product> getAll();

    /**
     * creates new product
     * @param productDto dto with product fields
     */
    void createProduct(ProductDto productDto);
}
