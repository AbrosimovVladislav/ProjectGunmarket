package ru.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gunmarket.model.Brand;
import ru.gunmarket.model.Product;
import ru.gunmarket.model.Type;
import ru.gunmarket.querybuilder.FilterAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long>, FilterAndSortingRepository<Product> {

    Optional<Product> findByProductId(Long productId);

    default void saveOrUpdate(Product product) {
        if (product.getName().isBlank()) return;
        findByBrandAndNameAndType(product.getBrand(), product.getName(), product.getType())
                .ifPresentOrElse(
                        p -> save(product.setProductId(p.getProductId())),
                        () -> save(product)
                );
    }

    Optional<Product> findByBrandAndNameAndType(Brand brand, String name, Type type);
}
