package az.edu.ada.wm2.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity                         // marks this class as a JPA-managed table
@Table(name = "product")        // explicit table name (optional but clear)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)   // auto-generate UUID primary key
    private UUID id;

    private String productName;
    private BigDecimal price;
    private LocalDate expirationDate;

    // Owner side of the Many-to-Many (owns the join table)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "product_category",                    // name of the join table
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @Builder.Default
    private List<Category> categories = new ArrayList<>();
}