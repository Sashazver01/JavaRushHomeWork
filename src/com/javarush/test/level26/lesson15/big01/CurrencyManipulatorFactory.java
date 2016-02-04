package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandr on 16.01.16.
 */
public class CurrencyManipulatorFactory
{
    public static Map<String, CurrencyManipulator> currencyManipulatorMap = new HashMap<String , CurrencyManipulator>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        CurrencyManipulator manipulator = currencyManipulatorMap.get(currencyCode);
        if (manipulator == null){
           manipulator = new CurrencyManipulator(currencyCode);
            currencyManipulatorMap.put(currencyCode,manipulator);
        }
        return manipulator;
    }

    private CurrencyManipulatorFactory()
    {

    }

     public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
     {
         return currencyManipulatorMap.values();
     }
}
