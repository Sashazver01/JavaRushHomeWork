package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandr on 27.01.16.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids){

        Long t1 = new Date().getTime();
        for(String s : strings) {
            ids.add(shortener.getId(s));
        }
        Long t2 = new Date().getTime();

        return t2 - t1;
    }
    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Long t1 = new Date().getTime();
        for(Long i : ids) {
            strings.add(shortener.getString(i));
        }
        Long t2 = new Date().getTime();

        return t2 - t1;
    }
    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Long testTime1 = getTimeForGettingIds(shortener1,origStrings,new HashSet<Long>());
        Long testTime2 = getTimeForGettingIds(shortener2, origStrings, new HashSet<Long>());
        Assert.assertTrue(testTime1>testTime2);

        Set<Long> Ids = new HashSet<>();
        for (long i = 0; i < 10000; i++) {
            Ids.add(i);
        }
        Long testTime3 = getTimeForGettingStrings(shortener1, Ids, new HashSet<String >());
        Long testTime4 = getTimeForGettingStrings(shortener2, Ids, new HashSet<String >());
        Assert.assertEquals(testTime3, testTime4,5);
    }

}
