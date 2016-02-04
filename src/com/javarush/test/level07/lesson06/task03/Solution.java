package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> listString = inputArrayListString(5);
        ArrayList<String> listMinleghtStrings = getMinleghtStrings(listString);
        for (int i = 0; i < listMinleghtStrings.size(); i++)
        {
            System.out.println(listMinleghtStrings.get(i));
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
    public static ArrayList<String> getMinleghtStrings(ArrayList<String> list)
    {
        ArrayList<String> rezult = new ArrayList<String>();
        int minLeght = list.get(0).length();
        rezult.add(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i).length() < minLeght)
            {
                rezult.clear();
                rezult.add(list.get(i));
                minLeght = list.get(i).length();
            } else
            {
                if (list.get(i).length() == minLeght)
                {
                    rezult.add(list.get(i));
                }
            }
        }
        return rezult;
    }
}
