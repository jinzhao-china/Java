package com.company.Generics;

/**
 * Created by zhaojin on 8/26/17.
 */
public class Fibonacci implements Generator<Integer>{
    private int count = 0;
    public Integer fib(int n){
        if(n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }
    @Override
    public Integer next() {
        return fib(count ++);
    }

    public static void main(String[] args){
        Fibonacci fib = new Fibonacci();

        for ( int i = 0; i < 10; i ++){
            int val = fib.next();
            System.out.println(val);
        }
    }
}
