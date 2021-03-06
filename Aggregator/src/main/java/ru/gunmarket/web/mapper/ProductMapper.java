package ru.gunmarket.web.mapper;

import org.springframework.stereotype.Component;
import ru.gunmarket.model.Product;
import ru.gunmarket.web.dto.ExtendedProductDto;
import ru.gunmarket.web.dto.ProductDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public List<ProductDto> productsToProductDtos(List<Product> products) {
        return products.stream().map(this::productToProductDto).collect(Collectors.toList());
    }

    public Set<ProductDto> productsToProductDtos(Set<Product> products) {
        return products.stream().map(this::productToProductDto).collect(Collectors.toSet());
    }

    public ExtendedProductDto productToExtendedProductDto(Product product) {
        return new ExtendedProductDto().setProductId(product.getProductId())
                .setName(product.getName())
                .setBrand(product.getBrand().getShortName())
                .setType(product.getType())
                .setCompatibleProduct(productsToProductDtos(product.getCompatibleProduct()));
    }

    public ProductDto productToProductDto(Product product) {
        return new ProductDto().setProductId(product.getProductId())
                .setName(product.getName())
                .setBrand(product.getBrand().getShortName())
                .setSrcImageUrl(product.getSrcImageUrl())
                .setType(product.getType());
    }

}
