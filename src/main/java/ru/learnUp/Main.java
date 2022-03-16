package ru.learnUp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;
import java.util.Set;

public class Main {
   public static void main(String[] args) {
// //       HttpClient client = new HttpClient();
// //       Datasource datasource = new Datasource();
// //       ModelsRepository repository = new ModelsRepository(datasource);

// //   ClassPathXmlApplicationContext создает все экземпляры классов из файла configuration.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");

// //       ModelsService service = new ModelsService(repository, client);

        ModelsService service = context.getBean(ModelsService.class);

        Collection<Model> models = service.getModels(1L);
        System.out.println(models);

       HttpClient client = context.getBean(HttpClient.class);

       client.enrichModelWithImagesAndName(Set.of(1L))
                .forEach(System.out::println);
   }
}
