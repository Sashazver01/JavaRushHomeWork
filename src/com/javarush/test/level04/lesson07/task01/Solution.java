package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String s = getDescriptionForNumber(n);
        System.out.println(s);

    }
    private static String getDescriptionForNumber(int n)
    {
        String description = "";
        if (n == 0)
        {
            description = "нулевое число";
        }
        if (n > 0 && n % 2 == 0)
        {
            description = "положительное четное число";
        }
        if (n < 0 && n % 2 == 0)
        {
            description = "отрицательное четное число";
        }
        if (n > 0 && n % 2 != 0)
        {
            description = "положительное нечетное число";
        }
        if (n < 0 && n % 2 != 0)
        {
            description = "отрицательное нечетное число";
        }


        return description;
    }
}
