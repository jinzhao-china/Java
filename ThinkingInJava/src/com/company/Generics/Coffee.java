package com.company.Generics;

/**
 * Created by zhaojin on 8/26/17.
 */
public class Coffee {
    private static long count = 0;
    private final long id = count ++;

    public String toString(){
        return getClass().getSimpleName() + "   " + id;
    }
}
