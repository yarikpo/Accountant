package ua.clamor1s.Accountant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.clamor1s.Accountant.entity.ProductType;

import java.util.UUID;

public interface ProductTypeRepository extends JpaRepository<ProductType, UUID> {
}
