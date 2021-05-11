package ru.gunmarket.web.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import ru.gunmarket.web.dto.ProductDto;

import java.util.List;

public interface ProductApi {

    @ApiOperation(value = "Get all products dto",
            notes = "Get all products dto",
            response = ResponseEntity.class)
    ResponseEntity<List<ProductDto>> getAll();

}
