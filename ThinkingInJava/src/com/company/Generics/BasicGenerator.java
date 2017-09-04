package com.company.Generics;

/**
 * Created by zhaojin on 8/27/17.
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type){
        this.type = type;
    }

    public T next(){
        try {
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }

    public static void main(String[] args){
        Generator<LatteCoffee> coffee = BasicGenerator.create(LatteCoffee.class);
        System.out.println(coffee.next());
    }
}
