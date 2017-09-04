package com.company.Generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojin on 8/27/17.
 */
public class GenericVarArgs {
    public static <T> List<T> makeList(T... args){
        List<T> lst = new ArrayList<T>();

        for (T arg :
                args) {
            lst.add(arg);
        }
        return lst;
    }

    public static void main(String[] args){
        List<String> lst = makeList("Hi");
        System.out.println(lst);
        lst = makeList(("it's good weather").split(""));
        System.out.println(lst);
    }
}
