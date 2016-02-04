package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream1 = new FileInputStream(fileName2);
        FileInputStream inputStream2 = new FileInputStream(fileName3);
       int count = 0;
       if (inputStream1.available() > 0){
            byte[] bufer1 = new byte[inputStream1.available()];
            count = inputStream1.read(bufer1);
            outputStream.write(bufer1,0,count);
       }
       if (inputStream2.available() > 0){
            byte[] bufer2 = new byte[inputStream2.available()];
            int count2 = inputStream2.read(bufer2);
            outputStream.write(bufer2,0,count2);
       }
        inputStream1.close();
        inputStream2.close();
        outputStream.close();


    }
}
