package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> list = inputArrayListString(5);
        circularShiftToTheRight(list,13);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }



    }
    public static ArrayList<String> inputArrayListString(int count) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listSting = new ArrayList<String>();
        for (int i = 0; i < count; i++)
        {
            listSting.add(reader.readLine());
        }
        return listSting;
    }
    public static void circularShiftToTheRight(ArrayList<String> list, int count)
    {
        String buf;
        for (int i = 0; i < count; i++)
        {
            buf = list.get(list.size()-1);
            list.remove(list.size()-1);
            list.add(0,buf);
        }
    }
}
