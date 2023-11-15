package ua.clamor1s.Accountant.service.interfaces;

import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.ProductType;

import java.util.List;

public interface ProductTypeService {

    /**
     * TODO
     * @return
     */
    List<ProductType> getAll();

    /**
     * TODO
     * @param productTypeDto
     */
    void createProductType(ProductTypeDto productTypeDto);

    /**
     * TODO
     * @param productType
     * @return
     */
//    ProductType updateProductType(ProductType productType);
}
