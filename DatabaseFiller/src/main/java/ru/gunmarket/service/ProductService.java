package ru.gunmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gunmarket.model.Product;
import ru.gunmarket.repo.ProductRepo;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public void save(Product product) {
        productRepo.saveOrUpdate(product);
    }

}
