package ru.gunmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gunmarket.repo.TypeRepo;
import ru.gunmarket.model.Type;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TypeService {

    private final TypeRepo typeRepo;

    public Optional<Type> findByShowName(String showName) {
        return typeRepo.findByShowName(showName);
    }
}
