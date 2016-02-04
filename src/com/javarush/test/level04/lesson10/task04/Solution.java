package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int count = 10;
        int current1 = 0;
        int current2 = 0;
        while (current1<count)
        {
            while (current2<count)
            {
                System.out.print("S");
                current2++;
            }
            current2 = 0;
            System.out.println();
            current1++;
        }

    }
}
