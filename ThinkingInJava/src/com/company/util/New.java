package com.company.util;

import java.util.*;

/**
 * Created by zhaojin on 8/26/17.
 */
public class New {
    public static <V,K> Map<V, K> map(){
        return new HashMap<V,K>();
    }

    public static <T> List<T> list(){
        return new ArrayList<T>();
    }
}
