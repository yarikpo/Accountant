package ua.clamor1s.Accountant.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.entity.ProductType;
import ua.clamor1s.Accountant.entity.enums.State;
import ua.clamor1s.Accountant.repository.ProductRepository;
import ua.clamor1s.Accountant.repository.ProductTypeRepository;
import ua.clamor1s.Accountant.service.interfaces.ProductService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(ProductDto productDto) {
        var product = setProductTypeWithFields(productDto);
        productRepository.save(product);
    }

    private Product setProductTypeWithFields(ProductDto productDto) {
        var product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(productDto.name());
        product.setTypeId(getProductTypeUUID(productDto));
        product.setPurchasePrice(productDto.purchasePrice());
        product.setRetailPriceBuy(productDto.retailPriceBuy());
        product.setRetailPriceSell(null);
        product.setPurchaseBuyDate(LocalDate.now());
        product.setState(State.BOUGHT);
        return product;
    }

    private ProductType getProductTypeUUID(ProductDto productDto) {
        return Objects.requireNonNull(productTypeRepository
                .findById(productDto.typeId())
                .orElse(null)); // TODO throw something
    }
}
