package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Arrays;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        int count = 3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[count];
        for (int i = 0; i < count; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array);
        System.out.println(array[1]);
    }

}
