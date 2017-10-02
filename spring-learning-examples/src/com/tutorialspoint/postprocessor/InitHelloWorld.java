package com.tutorialspoint.postprocessor;

/**
 * ApplicationContext 会自动检测由 BeanPostProcessor 接口的实现定义的 bean，
 * 注册这些 bean 为后置处理器，然后通过在容器中创建 bean，在适当的时候调用它。
 */
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitHelloWorld implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }
}

