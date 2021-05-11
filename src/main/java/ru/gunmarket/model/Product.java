package ru.gunmarket.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.gunmarket.model.product_attributes.Brand;
import ru.gunmarket.model.product_attributes.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

import static ru.gunmarket.model.Product.PRODUCT_TABLE;
import static ru.gunmarket.model.product_attributes.Brand.BRAND_ID;
import static ru.gunmarket.model.product_attributes.Type.TYPE_ID;

@Entity
@Table(name = PRODUCT_TABLE)
@Accessors(chain = true)
@Getter
@Setter
@ToString(exclude = "offer")
public class Product {
    public static final String PRODUCT_TABLE = "product";
    public static final String PRODUCT_ID = "productId";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = PRODUCT_ID, length = 8, nullable = false)
    private Long productId;

    private String name;

    private String extendedName;

    @ManyToOne
    @JoinColumn(name = BRAND_ID, nullable = false)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = TYPE_ID, nullable = false)
    private Type type;

    @OneToMany(mappedBy = PRODUCT_TABLE)
    private Set<Offer> offer = new HashSet<>();

    @ManyToMany
    private Set<Product> compatibleProduct;

    @Min(value = 0, message = "Product minPrice cannot be lower than 0")
    private Double minPrice;
    private Double maxPrice;
}