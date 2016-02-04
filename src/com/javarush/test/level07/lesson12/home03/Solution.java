package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum;
        int  minimum;

        //напишите тут ваш код
        ArrayList<Integer> list = inputArrayListInt(20);
        maximum = list.get(0);
        minimum = list.get(0);
        int current;
        for (int i = 0; i < list.size(); i++)
        {
            current = list.get(i);
            maximum = (maximum > current)? maximum: current;
            minimum = (minimum < current)? minimum: current;
        }



        System.out.println(maximum + " " +minimum);
//        System.out.println(minimum);
    }
    public static ArrayList<Integer> inputArrayListInt(int count) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < count; i++)
        {
            listInt.add(Integer.parseInt(reader.readLine()));
        }
        return listInt;
    }
}
