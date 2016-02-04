package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = consoleReader.readLine();
        String fileName2 = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        String text = "";
        while (fileReader.ready())
        {
            text = text + (char)fileReader.read();
        }
        fileReader.close();

        String replacedString   = text.replaceAll("\\p{P}","").toLowerCase();
        replacedString          = replacedString.replaceAll("\\s","");
        replacedString          = replacedString.replaceAll(System.clearProperty("line.separator"),"");

        fileWriter.write(replacedString);
        fileWriter.close();



    }
}
