package ru.gunmarket.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.gunmarket.model.Type;

import java.util.Set;

@Setter
@Getter
@Accessors(chain = true)
public class ExtendedProductDto {
    private Long productId;
    private String name;
    private String brand;
    private Type type;
    private Set<ProductDto> compatibleProduct;
}
