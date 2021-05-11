package ru.gunmarket.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.gunmarket.model.product_attributes.Type;

@Setter
@Getter
@Accessors(chain = true)
public class ProductDto {
    private Long productId;
    private String name;
    private String brand;
    private Type type;
}
