package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int sInt = 10;
        Integer sInteger = 12;
        print(sInt);
        print(sInteger);
    }

    //Напишите тут ваши методы
    public static void print(int s)
    {
        System.out.println(s);
    }
    public static void print(Integer  s)
    {
        System.out.println(s);
    }
}
