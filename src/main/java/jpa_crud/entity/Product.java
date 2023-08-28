package jpa_crud.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "SKU_Unique",
                        columnNames = "stock_keeping_unit"
                ),
                @UniqueConstraint(
                        name = "product_name",
                        columnNames ="name"
                )
        }
)
public class Product {

    //GeneratedType.Identity used for auto increment of the generating values
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_generator"
    )
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_seq_generator",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "stock_keeping_unit",nullable = true)
    private String sku;

    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imgUrl;

    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

}