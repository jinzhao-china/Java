package com.tutorialspoint.customevent;

/**
 * Created by zhaojin on 10/4/17.
 */
import org.springframework.context.ApplicationListener;
public class CustomEventHandler
        implements ApplicationListener<CustomEvent>{
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}
