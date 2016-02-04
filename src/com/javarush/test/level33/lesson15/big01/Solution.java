package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for(String s : strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for(Long key : keys) {
            result.add(shortener.getString(key));
        }
        return result;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStrings = new HashSet<>();
        for (long i = 0; i < elementsNumber; i++) {
            testStrings.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Long t1 = new Date().getTime();
        Set<Long> longSet = getIds(shortener, testStrings);
        Long t2 = new Date().getTime();
        Long t3 = new Date().getTime();
        Set<String> stringSet = getStrings(shortener, longSet);
        Long t4 = new Date().getTime();
        Long delta1 = t2 - t1;
        Long delta2 = t4 - t3;
        Helper.printMessage(delta1.toString());
        Helper.printMessage(delta2.toString());
        if (stringSet.equals(testStrings)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testStrategy(new HashMapStorageStrategy(), 10000L);
        solution.testStrategy(new OurHashMapStorageStrategy(), 10000L);
        solution.testStrategy(new OurHashBiMapStorageStrategy(), 10000L);
        solution.testStrategy(new FileStorageStrategy(), 10000L);

    }
}