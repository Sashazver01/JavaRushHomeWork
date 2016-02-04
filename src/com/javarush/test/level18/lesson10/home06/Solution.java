package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];
        FileInputStream inputStream = new FileInputStream(fileName);

        HashMap<Character, Integer> map = new HashMap<Character,Integer>();

        while (inputStream.available() > 0)
        {
            Character s = (char)inputStream.read();
            map.put(s,(map.get(s)==null)?1:map.get(s)+1);
        }
        inputStream.close();
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);

        for (int i = 0; i < keys.length; i++)
        {
            System.out.println(keys[i] + " " + map.get(keys[i]));
        }



    }
}
