package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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
        int maxCount = 0;
        while (inputStream.available() > 0)
        {
            currentdata = inputStream.read();
            int count = map.get(currentdata)==null?1:map.get(currentdata)+1;

            map.put(currentdata, count);
            if (count > maxCount)
                maxCount = count;
        }
        inputStream.close();
        ArrayList<Integer> maxDataList = getMaxCountArray(map,maxCount);
        for (int i = 0; i < maxDataList.size(); i++)
        {
            System.out.print(maxDataList.get(i) + " ");
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
}
