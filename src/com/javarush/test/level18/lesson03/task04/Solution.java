package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fulFileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fulFileName);


        HashMap<Integer, Integer> map = new HashMap<>();
        int currentdata;

        while (inputStream.available() > 0)
        {
            currentdata = inputStream.read();
            int count = map.get(currentdata)==null?1:map.get(currentdata)+1;

            map.put(currentdata, count);

        }
        inputStream.close();
        ArrayList<Integer> minDataList = getMaxCountArray(map,getMinCount(map));
        for (int i = 0; i < minDataList.size(); i++)
        {
            System.out.print(minDataList.get(i) + " ");
        }
    }

    private static ArrayList<Integer> getMaxCountArray(HashMap<Integer,Integer> map,int count){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            if (pair.getValue() == count)
                arrayList.add(pair.getKey());
        }

        return arrayList;
    }
    private static int getMinCount(HashMap<Integer,Integer> map){
         ArrayList<Integer> listValues = new ArrayList<Integer>();
          listValues.addAll(map.values());
        int minCount = listValues.get(0);
        for (int i = 1; i < listValues.size(); i++)
        {
            if (minCount > listValues.get(i))
                minCount = listValues.get(i);
        }
        return minCount;
    }
}
