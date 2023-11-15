package ua.clamor1s.Accountant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.clamor1s.Accountant.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
