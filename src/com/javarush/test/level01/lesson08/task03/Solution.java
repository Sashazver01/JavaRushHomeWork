package com.javarush.test.level01.lesson08.task03;

/* Решаем задачи
Напиши программу, которая выводит на экран надпись: «Хочешь - решай задачи, не хочешь - решай нехотя» 16 раз.
*/
public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        int cout = 4;

        String line = "Хочешь - решай задачи, не хочешь - решай нехотя";

        for (int i = 0; i < cout ; i++)
        {
            print4Times(line);
        }
    }

    public static void print4Times(String s)
    {
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }
}
