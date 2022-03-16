package ru.learnUp;

import java.util.Collection;

public class ModelsService {            //Это класс, помогющий получить информацию о моделях

    private final ModelsRepository modelsRepository;
    private final HttpClient client;

    public ModelsService(ModelsRepository modelsRepository, HttpClient client) {
        this.modelsRepository = modelsRepository;
        this.client = client;
    }

    public Collection<Model> getModels(long vendorID) {
      Collection<Long> models = modelsRepository.getModelsByVendor(vendorID);
      return client.enrichModelWithImagesAndName(models);  //возвращает коллекцию моделей,"обогащенную" с помощью
                                                          // метода класса HttpClient информацией о id, "Model", "url"
    }

}
