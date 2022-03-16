package ru.learnUp;

import java.util.Collection;
import java.util.stream.Collectors;

public class HttpClient {   //HttpClient позволяет "обогатить" модели информацией о id, "Model", "url"

    public Collection<Model> enrichModelWithImagesAndName(Collection<Long> modelIds) {
        return modelIds.stream()
                .map(id -> new Model(id, "Model", "url"))
                .collect(Collectors.toList());
    }

}
