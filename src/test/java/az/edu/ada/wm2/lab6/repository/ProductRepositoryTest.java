package az.edu.ada.wm2.lab6.repository;

import az.edu.ada.wm2.lab6.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setup() {
        productRepository.deleteAll();
    }

    @Test
    void findByPriceBetween_shouldReturnResults() {

        Product p1 = Product.builder()
                .productName("A")
                .price(new BigDecimal("10"))
                .build();

        Product p2 = Product.builder()
                .productName("B")
                .price(new BigDecimal("50"))
                .build();

        productRepository.save(p1);
        productRepository.save(p2);

        List<Product> result =
                productRepository.findByPriceBetween(
                        new BigDecimal("5"),
                        new BigDecimal("20")
                );

        assertEquals(1, result.size());
    }

    @Test
    void shouldReturnEmpty_whenNoMatch() {

        Product p = Product.builder()
                .productName("A")
                .price(new BigDecimal("100"))
                .build();

        productRepository.save(p);

        List<Product> result =
                productRepository.findByPriceBetween(
                        new BigDecimal("1"),
                        new BigDecimal("10")
                );

        assertTrue(result.isEmpty());
    }

    @Test
    void findByExpirationDateBefore_shouldReturnResults() {

        Product p = Product.builder()
                .productName("Milk")
                .expirationDate(LocalDate.now().minusDays(1))
                .build();

        productRepository.save(p);

        List<Product> result =
                productRepository.findByExpirationDateBefore(LocalDate.now());

        assertEquals(1, result.size());
    }
}