package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> listString = inputArrayListString(5);
        ArrayList<String> listMaxleghtStrings = getMaxleghtStrings(listString);
        for (int i = 0; i < listMaxleghtStrings.size(); i++)
        {
            System.out.println(listMaxleghtStrings.get(i));
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
    public static ArrayList<String> getMaxleghtStrings(ArrayList<String> list)
    {
        ArrayList<String> rezult = new ArrayList<String>();
        int maxLeght = -1;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() > maxLeght)
            {
                rezult.clear();
                rezult.add(list.get(i));
                maxLeght = list.get(i).length();
            }
            else
            {
                if (list.get(i).length() >= maxLeght)
                {
                    rezult.add(list.get(i));
                }
            }
        }
        return rezult;
    }

}
