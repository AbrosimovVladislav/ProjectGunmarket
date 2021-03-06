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
import ru.gunmarket.web.mapper.ProductMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductDetailsPageApiController implements ProductDetailsPageApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @CrossOrigin
    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtendedProductDto> getById(@PathVariable long productId) {
        Product product = productService.getById(productId);
        return ResponseEntity.ok(productMapper.productToExtendedProductDto(product));
    }

}
