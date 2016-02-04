package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = reader.readLine();
        String filename1 = filename;
        HashMap<String, byte[]> map = new HashMap<>();
        while(!"end".equals(filename))
        {

            FileInputStream fileInputStream = new FileInputStream(filename);
            byte[] data = new byte[fileInputStream.available()];
            int count = fileInputStream.read(data);
            map.put(filename, data);
            fileInputStream.close();

            filename = reader.readLine();
        }
        reader.close();

        int LastSymbolDirectoryName = filename1.lastIndexOf((int) ".".charAt(0));
        String DirectoryName = filename1.substring(0, LastSymbolDirectoryName);
        String FileOutputName = DirectoryName ;

        Object[] arrayKeys = map.keySet().toArray();
        Arrays.sort(arrayKeys);
        FileOutputStream fileOutputStream = new FileOutputStream(FileOutputName);
        for (int i = 0; i < arrayKeys.length; i++)
        {
            byte[] curenntData = map.get(arrayKeys[i]);
            fileOutputStream.write(curenntData);
        }
        fileOutputStream.close();



    }
}
