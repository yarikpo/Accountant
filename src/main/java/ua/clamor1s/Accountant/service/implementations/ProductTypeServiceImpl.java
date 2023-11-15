package ua.clamor1s.Accountant.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.ProductType;
import ua.clamor1s.Accountant.repository.ProductTypeRepository;
import ua.clamor1s.Accountant.service.interfaces.ProductTypeService;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    @Transactional
    public void createProductType(ProductTypeDto productTypeDto) {
        var productType = setProductTypeWithFields(productTypeDto);
        productTypeRepository.save(productType);
    }

    private ProductType setProductTypeWithFields(ProductTypeDto productTypeDto) {
        var productType = new ProductType();
        productType.setId(UUID.randomUUID());
        productType.setName(productTypeDto.name());
        productType.setDepreciationLimit(productTypeDto.depreciationLimit());
        productType.setDepreciationSellRate(productTypeDto.depreciationSellRate());
        productType.setDepreciation(productTypeDto.depreciation());
        productType.setDepreciationPeriod(productTypeDto.depreciationPeriod());
        productType.setBenefitRate(productTypeDto.benefitRate());
        productType.setBenefitPeriod(productTypeDto.benefitPeriod());
        return productType;
    }
}
