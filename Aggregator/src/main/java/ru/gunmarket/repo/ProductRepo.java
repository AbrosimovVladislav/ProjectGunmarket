package ru.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gunmarket.model.Product;
import ru.gunmarket.querybuilder.FilterAndSortingRepository;

public interface ProductRepo extends JpaRepository<Product, Long>, FilterAndSortingRepository<Product> {
}
