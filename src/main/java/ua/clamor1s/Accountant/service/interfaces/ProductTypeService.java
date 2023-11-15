package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.ProductType;

import java.util.List;

public interface ProductTypeService {

    /**
     * receives all product types
     * @return list of products
     */
    List<ProductType> getAll();

    /**
     * creates new product type
     * @param productTypeDto dto with product type fields
     */
    void createProductType(ProductTypeDto productTypeDto);
}
