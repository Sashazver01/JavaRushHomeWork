package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
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
        if (s.length() != 0)
        {
            System.out.println(s);
        }
    }
    private static String getDescriptionForNumber(int n)
    {
        String description = "";

        if (n >= 1 && n < 10 && n % 2 == 0)
        {
            description = "четное однозначное число";
        }
        if (n >= 1 && n < 10 && n % 2 != 0)
        {
            description = "нечетное  однозначное число";
        }
        if (n >=10 &&  n < 100 && n % 2 == 0)
        {
            description = "четное двузначное число";
        }
        if (n < 1000 && n >= 100 && n % 2 == 0)
        {
            description = "четное  трехзначное число";
        }
        if ( n >=10 &&   n < 100 && n % 2 != 0)
        {
            description = "нечетное двузначное число";
        }
        if (n < 1000 && n >= 100 && n % 2 != 0)
        {
            description = "нечетное  трехзначное число";
        }



        return description;
    }
}
