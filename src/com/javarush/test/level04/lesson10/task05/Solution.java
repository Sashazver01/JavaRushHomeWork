package com.javarush.test.level04.lesson10.task05;

import java.io.*;

/* Таблица умножения
Вывести на экран таблицу умножения 10х10 используя цикл while.
Числа разделить пробелом.
1 2 3 4 5 6 7 8 9 10
2 4 6 8 10 12 14 16 18 20
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int coun = 10;
        int current1 = 1;
        int current2 = 1;
        while (current1 <= 10)
        {
            while (current2 <= 10)
            {
                System.out.print(current1*current2 + " ");
                current2++;
            }
            System.out.println();
            current2 = 1;
            current1++;
        }

    }
}
