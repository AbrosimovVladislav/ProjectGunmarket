package ru.gunmarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gunmarket.repo.BrandRepo;
import ru.gunmarket.model.Brand;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepo brandRepo;

    public Brand getByShortName(String shortName) {
        return brandRepo.findByShortName(shortName);
    }

}
