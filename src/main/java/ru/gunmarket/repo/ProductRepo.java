package ru.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gunmarket.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
