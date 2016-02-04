package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileNAme = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileNAme));

        HashMap<String ,Double> map = new HashMap<>();

        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            String [] data = line.split(" ");
            String name = data[0];
            String number = data[1];
            double numberd = Double.parseDouble(number);
            double newsum = (map.get(name)==null)?numberd:numberd+map.get(name);
            map.put(name,newsum);

        }
        fileReader.close();

        Object [] keyssort =  map.keySet().toArray();
        Arrays.sort(keyssort);
        for (int i = 0; i < keyssort.length; i++)
        {
            System.out.println(keyssort[i]+ " "  + map.get(keyssort[i]));
        }


    }
}
