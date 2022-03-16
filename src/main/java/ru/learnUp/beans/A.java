package ru.learnUp.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


//public class A {         //вариант 1
@Slf4j                     //вариант 2
public class A implements InitializingBean, DisposableBean {

    private final B b;   //обьект final очень удобен для сборщика мусора, тк ссылка на него постоянна

    //поэтому внедрение(injection) зависимостей через конструктор самая правильная
    public A(B b) {
        this.b = b;
//        System.out.println();
//        log.debug("A created");
        log.info("A created");
    }

    // без обьявления конструктора нельзя присвоить обьекту свойство final
    // поэтому вариант 2 без конструктора и с (<property name="b" ref="b"/>)  в xml хуже

//    @Autowired
//    private  B b;

//    public void setB(B b) {
//        this.b = b;
//    }

    public void useBFunction() {   //вызываем функции из класса B
        b.print();
    }

//    @PostConstruct
    private void initMe() {
//        log.debug("InitMe function used");
        log.info("InitMe function used");
    }

    private void destroyMe() {
        log.info("My bean is destroyed");
    }

    //вариант 2
    @Override
    public void afterPropertiesSet() throws Exception {
          initMe();
    }

    @Override
    public void destroy() throws Exception {
        destroyMe();
    }
}
