package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream  inputStream1   = new FileInputStream(fileName1);
        FileInputStream  inputStream2   = new FileInputStream(fileName2);
        byte[] buffile1 = new byte[inputStream1.available()];
        byte[] buffile2 = new byte[inputStream2.available()];
        int count1 = 0;
        int count2 = 0;
        if (inputStream1.available() > 0)
            count1 = inputStream1.read(buffile1);
        if (inputStream2.available() > 0)
            count2 = inputStream2.read(buffile2);
        inputStream1.close();
        inputStream2.close();

        FileOutputStream outputStream   = new FileOutputStream(fileName1);
        outputStream.write(buffile2,0,count2);
        outputStream.write(buffile1,0,count1);
        outputStream.close();

    }
}
