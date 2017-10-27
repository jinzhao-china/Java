package com.tutorialspoint.customevent;

/**
 * Created by zhaojin on 10/4/17.
 */
import org.springframework.context.ApplicationEvent;
public class CustomEvent extends ApplicationEvent{
    public CustomEvent(Object source) {
        super(source);
    }
    public String toString(){
        return "My Custom Event";
    }
}