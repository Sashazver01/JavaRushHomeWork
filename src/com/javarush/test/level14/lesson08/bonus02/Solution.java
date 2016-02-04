package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        System.out.println(getGreatestCommonDivisor(a, b));

    }
    private static int getGreatestCommonDivisor(int a, int b)
    {
        int res = 0;
        while (a != 0 && b !=0)
        {
            if(a > b)
                a = a%b;
            else
                b = b%a;
        }
        res = a + b;

        return res;
    }
}
