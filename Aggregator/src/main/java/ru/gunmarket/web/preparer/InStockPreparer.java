package ru.gunmarket.web.preparer;

import org.springframework.stereotype.Component;
import ru.gunmarket.querybuilder.BasicEntity;

@Component
public class InStockPreparer implements Preparer {
    @Override
    public void prepare(FilterAndPageable filterAndPageable, Class<? extends BasicEntity> entityClass) {
        String inStock = filterAndPageable.getFilter().get("offer.inStock");
        if (inStock != null && inStock.equals("false")) {
            filterAndPageable.getFilter().remove("offer.inStock");
        }
    }
}
