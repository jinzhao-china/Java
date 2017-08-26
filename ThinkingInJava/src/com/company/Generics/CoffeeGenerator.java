package com.company.Generics;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by zhaojin on 8/26/17.
 */
public class CoffeeGenerator implements Generator<Coffee> , Iterable<Coffee>{
    private Class[] types = {LatteCoffee.class , Mocha.class};
    private Random rnd = new Random(47);
    private int size = 0;
    public  CoffeeGenerator(int sz){
        this.size = sz;
    }
    @Override
    public Coffee next() {
        try{
            return (Coffee)types[rnd.nextInt(types.length)].newInstance();
        }
        catch (Exception e){
            return null;
        }
    }

    private class CoffeeIterator implements  Iterator<Coffee>{
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Coffee next() {
            size --;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {

        }
    }
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args){
        CoffeeGenerator gen = new CoffeeGenerator(3);
        for (Coffee item :
                gen) {
            System.out.println(item);
        }
    }
}