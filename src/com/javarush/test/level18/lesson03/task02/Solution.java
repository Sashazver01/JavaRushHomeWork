package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fulFileName = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(fulFileName);

        int dataMin= inputStream.read();
        int currentData;
        while (inputStream.available() > 0){
            currentData = inputStream.read();
            if (currentData<dataMin)
                dataMin = currentData;
        }
        System.out.println(dataMin);
        inputStream.close();
    }
}
