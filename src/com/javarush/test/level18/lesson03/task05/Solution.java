package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fulFileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fulFileName);


        HashSet<Integer> data = new HashSet<Integer>();
        int currentdata;

        while (inputStream.available() > 0)
        {
            currentdata = inputStream.read();
            data.add(currentdata);

        }
        inputStream.close();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(data);
        sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.print(arrayList.get(i)+ " ");
        }


    }
    private static void sort(ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size()-1; i++)
        {
            for (int j = i+1; j < arrayList.size(); j++)
            {
                if (arrayList.get(i)>arrayList.get(j)){
                    Integer buf = arrayList.get(i);
                    arrayList.set(i,arrayList.get(j));
                    arrayList.set(j,buf);
                }
            }

        }
    }
}
