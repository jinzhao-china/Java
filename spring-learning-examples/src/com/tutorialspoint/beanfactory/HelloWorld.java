package com.tutorialspoint.beanfactory;

/**
 * Created by zhaojin on 10/2/17.
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
