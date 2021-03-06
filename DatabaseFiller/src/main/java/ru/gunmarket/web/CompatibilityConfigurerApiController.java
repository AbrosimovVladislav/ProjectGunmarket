package ru.gunmarket.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.gunmarket.model.Product;
import ru.gunmarket.service.ProductService;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompatibilityConfigurerApiController {

    private final ProductService productService;

    @CrossOrigin
    @PostMapping(value = "compatibility", produces = MediaType.APPLICATION_JSON_VALUE)
    public Long addOrUpdateCompatibility(@RequestBody Map<String, String> compatibilityIds) {
        Long keyProductId = Long.parseLong(compatibilityIds.keySet().iterator().next());
        Product keyProduct = productService.getById(keyProductId);
        List<Product> compatibleProducts = productService.getByIds(Arrays.stream(compatibilityIds.values().iterator().next()
                .split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList()));
        keyProduct.setCompatibleProduct(new HashSet<>(compatibleProducts));
        productService.save(keyProduct);

        compatibleProducts.stream()
                .peek(compatibleProduct -> compatibleProduct.getCompatibleProduct().add(keyProduct))
                .forEach(productService::save);

        return keyProductId;
    }

    @DeleteMapping(value = "compatibility/{prodId-prodId}")
    public void deleteCompatibility(@PathVariable String productIdsPair) {

    }


}
