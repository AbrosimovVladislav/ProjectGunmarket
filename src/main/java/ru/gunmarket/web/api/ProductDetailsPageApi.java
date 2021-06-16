package ru.gunmarket.web.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import ru.gunmarket.web.dto.ExtendedProductDto;
import ru.gunmarket.web.dto.ProductDto;

public interface ProductDetailsPageApi {

    @ApiOperation(value = "Get extended product dto by id",
            notes = "Get extended product dto by id",
            response = ProductDto.class)
    ResponseEntity<ExtendedProductDto> getById(long productId);

}
