package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        String text = "";
        while (reader.ready())
        {
            text = text + reader.readLine()+" ";
        }
        reader.close();

        String[] data = text.split(" ");
        String newText = "";
        for (int i = 0; i < data.length; i++)
        {
            if (data[i].length()>6){
                newText = newText + data[i] +",";
            }
        }
        newText = newText.substring(0,newText.length()-1);

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        writer.write(newText);
        writer.close();



    }
}
