package ru.gunmarket.web.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import ru.gunmarket.web.dto.ExtendedProductDto;
import ru.gunmarket.web.dto.ProductDto;

import java.util.List;

public interface ProductApi {

    @ApiOperation(value = "Get all products dto",
            notes = "Get all products dto",
            response = ResponseEntity.class)
    ResponseEntity<List<ProductDto>> getAll();

    @ApiOperation(value = "Get extended product dto by id",
            notes = "Get extended product dto by id",
            response = ProductDto.class)
    ResponseEntity<ExtendedProductDto> getById(long productId);

}
