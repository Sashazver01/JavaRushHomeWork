package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        String text = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()){
           text = text + fileReader.readLine() + "\n";
        }
        reader.close();
        fileReader.close();
        String dataString = text.replaceAll("\n", " ");
        String[] data = dataString.split(" ");
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < data.length -1; i++)
        {
            for (int j = i+1; j < data.length; j++)
            {
                StringBuilder s = new StringBuilder(data[i]);
                s.reverse();
                if (s.toString().equals(data[j])
                    ){
                    map.put(data[i],data[j]);
                }
            }
        }
        for (Map.Entry<String,String> pair : map.entrySet()){
            Pair p = new Pair();
            p.first = pair.getKey();
            p.second = pair.getValue();
            result.add(p);
        }
        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i).first + " " + result.get(i).second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
