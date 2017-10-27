package com.tutorialspoint.customevent;

/**
 * Created by zhaojin on 10/4/17.
 */
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("com/tutorialspoint/customevent/Beans.xml");
        CustomEventPublisher cvp =
                (CustomEventPublisher) context.getBean("customEventPublisher");
        cvp.publish();
        cvp.publish();
    }
}
