package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] a = new int[4];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(a);
        System.out.println(a[a.length-1]);

    }
}
