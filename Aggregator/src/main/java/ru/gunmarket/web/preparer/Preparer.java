package ru.gunmarket.web.preparer;

import ru.gunmarket.querybuilder.BasicEntity;

public interface Preparer {
    void prepare(FilterAndPageable filterAndPageable, Class<? extends BasicEntity> entityClass);
}
