package ru.learnUp;

import java.util.Collection;
import java.util.Set;

public class ModelsRepository {             //Это класс, хранящий информацию о моделях

    private final Datasource datasource;     //источник данных для репозитория

    public ModelsRepository(Datasource datasource) {
        this.datasource = datasource;
    }

    public Collection<Long> getModelsByVendor(long vendorID) {
         return Set.of(1L, 2L, 3L);          // возвращаем Set с тремя элементами - идентификаторами модели
    }

    public Collection<Long> getModelsByCategory(long categoryID) {
        return Set.of(5L, 6L, 7L);          // возвращаем Set с тремя элементами - идентификаторами категории
    }


}
