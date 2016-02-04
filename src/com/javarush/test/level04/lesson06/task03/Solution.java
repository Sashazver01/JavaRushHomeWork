package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] array = new int[3];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }

    }
    public static void sort(int [] a)
    {
        int buf;
        for (int i = 0; i < a.length - 1; i++)
        {
            for (int j = i+1; j < a.length; j++)
            {
                if (a[i] < a[j])
                {
                    buf = a[i];
                    a[i] = a[j];
                    a[j] = buf;
                }
            }
        }
    }
}
