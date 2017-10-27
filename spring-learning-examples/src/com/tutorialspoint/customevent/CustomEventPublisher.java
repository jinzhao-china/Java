package com.tutorialspoint.customevent;

/**
 * Created by zhaojin on 10/4/17.
 */
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
public class CustomEventPublisher
        implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    public void setApplicationEventPublisher
            (ApplicationEventPublisher publisher){
        this.publisher = publisher;
    }
    public void publish() {
        CustomEvent ce = new CustomEvent(this);
        publisher.publishEvent(ce);
    }
}