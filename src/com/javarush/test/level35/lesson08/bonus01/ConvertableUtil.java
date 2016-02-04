package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConvertableUtil {

    public static  <T>Map<T,? extends Convertable<T>> convert(List<? extends Convertable<T>> list) {
        Map<T,Convertable<T>> res =  new HashMap();
        for(Convertable<T> key: list){
            res.put(key.getKey(),key);
        }
        return res;
    }
}
