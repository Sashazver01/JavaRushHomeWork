package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int []  array = new int[3];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println("количество отрицательных чисел: " + countNegative(array));
        System.out.println("количество положительных чисел: " + countPozitive(array));


    }
    private  static int countPozitive(int[] array)
    {
        int countPozitive = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] >= 0)
            {
                countPozitive++;
            }
        }
        return countPozitive;
    }
    private  static int countNegative(int[] array)
    {
        int countNegatove = array.length - countPozitive(array);

        return countNegatove;
    }
}
