package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = consoleReader.readLine();
        String fileName2 = consoleReader.readLine();
        consoleReader.close();

        FileReader  fileReader = new FileReader(fileName1);
        FileWriter  fileWriter = new FileWriter(fileName2);

        String text = "";
        while (fileReader.ready())
        {
            text = text + (char)fileReader.read();
        }
        fileReader.close();

        String s = "[.]";
        String newText = text.replaceAll(s,"!");
        fileWriter.write(newText);
        fileWriter.close();
    }
}
