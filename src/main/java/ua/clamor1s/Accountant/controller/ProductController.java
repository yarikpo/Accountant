package ua.clamor1s.Accountant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.clamor1s.Accountant.dto.ProductDto;
import ua.clamor1s.Accountant.entity.Product;
import ua.clamor1s.Accountant.service.interfaces.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProductDto productDto) {
        productService.createProduct(productDto);
        return ResponseEntity.noContent().build();
    }


//    TODO add update & delete
}
