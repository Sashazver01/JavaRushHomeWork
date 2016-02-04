package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


        double max = Double.MIN_VALUE;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String,Double> pair : map.entrySet())
        {
            if (pair.getValue()>max)
            {
                arrayList.clear();
                arrayList.add(pair.getKey());
            }else if (pair.getValue()==max)
                arrayList.add(pair.getKey());

        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.println(arrayList.get(i));
        }

    }
}
