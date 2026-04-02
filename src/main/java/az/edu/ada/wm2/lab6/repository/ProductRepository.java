package az.edu.ada.wm2.repository;

import az.edu.ada.wm2.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Spring Data derives the SQL from the method name automatically
    List<Product> findByExpirationDateBefore(LocalDate date);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}