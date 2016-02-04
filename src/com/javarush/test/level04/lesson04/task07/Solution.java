package com.javarush.test.level04.lesson04.task07;

/* Количество дней в году
Ввести с клавиатуры год, определить количество дней в году. Результат вывести на экран в следующем виде:
"количество дней в году: x", где х - 366 для високосными года, х - 365 для обычного года.
Подсказка: В високосном году - 366 дней, тогда как в обычном  - 365.
Високосным годом является каждый четвёртый год, за исключением столетий, которые не кратны 400.
Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
Годы 1600 и 2000 — високосные, так как они кратны 100 и кратны 400.
Годы 2100, 2200 и 2300 — невисокосные.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int year = inputInt();
        System.out.println("количество дней в году: " + countDayOfYear(year));


    }
    public static int inputInt()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while (true)
        {
            try
            {
                n = Integer.parseInt(reader.readLine());
                break;
            }
            catch (Exception e)
            {

            }
        }
        return n;
    }
    public static boolean itIsLeapYear(int year)
    {
        boolean rezult = false;
        if ( !((year%100==0) &&!(year%400 == 0))&& (year%4==0))
        {
            rezult = true;
        }
        return rezult;
    }
    public static int countDayOfYear(int year)
    {
        return (itIsLeapYear(year))? 366: 365;
    }

}