package com.javarush.test.level03.lesson12.home02;

/* Я не хочу изучать Java, я хочу большую зарплату
Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        int count = 10;
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        PrinCount(s, count);
    }

    public static void PrinCount(String s , int count)
    {
        for (int i = 0; i < count; i++)
        {
            System.out.println(s);
        }
    }
}
