package com.company.Generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhaojin on 8/26/17.
 */
public class RandomList<T> {
    private ArrayList<T> lst = new ArrayList<>();
    private Random rnd = new Random(47);

    public void add(T item){
        lst.add(item);
    }

    public T select(){
        return lst.get(rnd.nextInt(lst.size()));
    }

    public static void main(String[] args){
        RandomList<String> lst = new RandomList<>();
        for (String item:
                ("Hi where are you").split(" ")) {
            lst.add(item);
        }

        String val1 = lst.select();
        System.out.println(val1);
        String val2 = lst.select();
        System.out.println(val2);
    }
}
