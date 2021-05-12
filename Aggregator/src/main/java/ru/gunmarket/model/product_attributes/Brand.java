package ru.gunmarket.model.product_attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.gunmarket.model.Product;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

import static ru.gunmarket.model.product_attributes.Brand.BRAND_TABLE;

@Data
@Entity
@Table(name = BRAND_TABLE)
@ToString(exclude = "product")
public class Brand {
    public static final String BRAND_TABLE = "brand";
    public static final String BRAND_ID = "brand_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BRAND_ID, length = 8, nullable = false)
    private Long brandId;

    private String shortName;
    private String fullName;

    @JsonIgnore
    @OneToMany(mappedBy = BRAND_TABLE)
    private Set<Product> product;
}
