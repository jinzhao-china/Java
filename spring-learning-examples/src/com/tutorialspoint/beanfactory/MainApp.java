package com.tutorialspoint.beanfactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zhaojin on 10/2/17.
 */
public class MainApp {
    public static void main(String[] args){
        XmlBeanFactory factory = new XmlBeanFactory
                (new ClassPathResource("com/tutorialspoint/lifecycle/Beans.xml"));
        HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        obj.getMessage();
    }
}
