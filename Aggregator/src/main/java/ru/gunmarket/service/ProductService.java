package ru.gunmarket.service;

import ru.gunmarket.model.Product;
import ru.gunmarket.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;

    public Product getById(long id) {
        return productRepo.getOne(id);
    }

    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
