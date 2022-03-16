package ru.learnUp.beans;

//import lombok.Value;  //для вариата 2
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;  //для вариата 3

@Slf4j
public class B {

    private final String tag;

    private  int version;

    //Вариант 3
        public B(
//            @Value("${my.custom.field}")
//           @Value("world")
                    String tag
        ) {
        this.tag = tag;
        log.info(tag);
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void print() {
//        System.out.println("Hello");
//        log.info("Hello");
        //Вариант 3
        log.info("Hello " + tag + " " + version);
    }
}
