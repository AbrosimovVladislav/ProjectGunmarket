package ru.gunmarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gunmarket.model.Type;

import java.util.Optional;

public interface TypeRepo extends JpaRepository<Type, Long> {
    Optional<Type> findByShowName(String showName);
}
