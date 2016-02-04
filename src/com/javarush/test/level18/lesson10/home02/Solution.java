package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)  throws IOException{

        String fileName  = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        int countProbel = 0;
        while (inputStream.available() > 0)
        {
            count++;
            if (inputStream.read() == 32)
                countProbel++;

        }
        inputStream.close();
        double ratio = ((double) countProbel / count) *100;

        Double ratioRound = Math.round(ratio * 100)/100.0;

        System.out.println(ratioRound);
    }
}
