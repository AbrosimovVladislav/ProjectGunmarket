package ru.gunmarket.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.gunmarket.model.Product;
import ru.gunmarket.service.ProductService;
import ru.gunmarket.web.dto.ExtendedProductDto;
import ru.gunmarket.web.dto.ProductDto;
import ru.gunmarket.web.mapper.ProductMapper;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductApiController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @CrossOrigin
    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExtendedProductDto getById(@PathVariable long productId) {
        Product product = productService.getById(productId);
        return productMapper.productToExtendedProductDto(product);
    }

    @CrossOrigin
    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(productMapper.productsToProductDtos(products));
    }
}
