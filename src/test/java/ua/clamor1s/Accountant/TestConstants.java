package ua.clamor1s.Accountant;

import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.entity.ProductType;

import java.util.UUID;

public class TestConstants {
    public static UUID PRODUCT_UUID = UUID.randomUUID();

    public static UUID PRODUCT_TYPE_ID = UUID.randomUUID();


    private static Product makeNewProduct() {
        Product product = new Product();
        product.setId(PRODUCT_UUID);
        return product;
    }

    public static Product getProductWithId() {
        Product product = new Product();
        product.setId(PRODUCT_UUID);
        return product;
    }

    public static ProductType getProductTypeWithId() {
        ProductType productType = new ProductType();
        productType.setId(PRODUCT_TYPE_ID);
        return productType;
    }
}
