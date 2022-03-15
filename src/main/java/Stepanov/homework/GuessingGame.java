package Stepanov.homework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class GuessingGame implements ApplicationContextAware {

    static int randomNumber;
    static Locale locale;

    public static void main(String[] args) {

        Random random = new Random();
        randomNumber = random.nextInt(1000);

        Scanner scanner = new Scanner(System.in);

        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        MyEventListener listener = context.getBean((MyEventListener.class));

        locale = Locale.getDefault();
        System.out.println(locale.getCountry());
        System.out.println(context.getMessage("hello", null, locale));

        while (!listener.getMessage().equals("right")) {
            try {
                publisher.publishEvent(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println("Введенные символы не являются числом. Введите число!");
                scanner.next();
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}