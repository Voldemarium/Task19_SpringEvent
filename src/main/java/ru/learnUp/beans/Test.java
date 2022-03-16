package ru.learnUp.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.PropertyResolver;
import ru.learnUp.events.MyEventPublisher;

import java.util.Locale;

@Slf4j
public class Test implements ApplicationContextAware {  //имплементим интерфейс ApplicationContextAware, если нужно
    //в бинах воспользоваться  ApplicationContext

    private ApplicationContext context;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        A a = (A) context.getBean("a");
        a.useBFunction();

        //Для Event
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        publisher.publishEvent("Good event");

        Locale locale = Locale.getDefault();
        log.info(locale.getCountry());
        log.info(context.getMessage("hello", null, Locale.getDefault()));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
     //   System.out.println(applicationContext);
    }


}
