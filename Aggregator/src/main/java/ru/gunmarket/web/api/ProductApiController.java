package ru.gunmarket.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gunmarket.model.Product;
import ru.gunmarket.service.ProductService;
import ru.gunmarket.web.dto.ExtendedProductDto;
import ru.gunmarket.web.dto.ProductDto;
import ru.gunmarket.web.mapper.ProductMapper;
import ru.gunmarket.web.preparer.FilterAndPageable;
import ru.gunmarket.web.preparer.Preparer;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductApiController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final List<Preparer> preparers;

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 3000;

    @CrossOrigin()
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getAllByParams(@RequestParam Map<String, String> requestParams,
                                           @PageableDefault(size = DEFAULT_PAGE_SIZE, page = DEFAULT_PAGE_NUMBER) Pageable pageable) {

        log.info("Incoming request. Params {}. {}", requestParams, pageable);

        FilterAndPageable filterAndPageable = new FilterAndPageable(requestParams, pageable);
        preparers.forEach(preparer -> preparer.prepare(filterAndPageable, Product.class));

        List<Product> products = productService.getAllByParameters(
                filterAndPageable.getFilter(),
                filterAndPageable.getPageable()
        );

        List<ProductDto> result = productMapper.productsToProductDtos(products);
        log.info("GetAllByParams request result size: {}", requestParams.size());
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExtendedProductDto> getById(@PathVariable long productId) {
        Product product = productService.getById(productId);
        return ResponseEntity.ok(productMapper.productToExtendedProductDto(product));
    }

    @CrossOrigin
    @GetMapping(value = "/allProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.getAll();
        return ResponseEntity.ok(productMapper.productsToProductDtos(products));
    }
}
