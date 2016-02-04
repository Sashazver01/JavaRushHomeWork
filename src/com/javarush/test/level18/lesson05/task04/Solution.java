package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fulFileName1 = reader.readLine();
        String fulFileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fulFileName1);
        byte [] data = new byte[inputStream.available()];
        int count = 0;
        if (inputStream.available()>0)
        {
            count = inputStream.read(data);
        }
        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(fulFileName2);
        for (int i = count -1; i >=0 ; i--)
        {
            outputStream.write((int)data[i]);
        }
        outputStream.close();
    }
}
