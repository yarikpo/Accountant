package ua.clamor1s.Accountant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.clamor1s.Accountant.dto.ProductTypeDto;
import ua.clamor1s.Accountant.entity.ProductType;
import ua.clamor1s.Accountant.service.interfaces.ProductTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product_type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> getAll() {
        return productTypeService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProductTypeDto productTypeDto) {
        productTypeService.createProductType(productTypeDto);
        return ResponseEntity.noContent().build();
    }

// TODO add update & delete

}
