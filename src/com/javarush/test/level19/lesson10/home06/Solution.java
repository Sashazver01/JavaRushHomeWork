package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(12,"двенадцать");
        map.put(11,"одинадцать");
        map.put(10,"десять");
        map.put(9,"девять");
        map.put(8,"восемь");
        map.put(7,"семь");
        map.put(6,"шесть");
        map.put(5,"пять");
        map.put(4,"четыре");
        map.put(3,"три");
        map.put(2,"два");
        map.put(1,"один");
        map.put(0,"ноль");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader =  new BufferedReader(new FileReader(fileName));

        String text = "";
        while (fileReader.ready()){
            text = text +fileReader.readLine() + "\n";
        }
        fileReader.close();
        String newText = "";
        String [] data = text.split(" ");
        for (int i = 0; i < data.length; i++)
        {
            if(checkString(data[i]) &&!(map.get(Integer.parseInt(data[i]))==null)){
                data[i] = map.get(Integer.parseInt(data[i]));
            }
            newText = newText + data[i] + " ";
        }
        System.out.println(newText);




    }
    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}
