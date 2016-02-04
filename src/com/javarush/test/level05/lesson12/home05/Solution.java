package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        System.out.println(inputIntReturnSum("сумма"));
    }
    private static int inputIntReturnSum(String end) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        int currentInt ;
        String currentString = reader.readLine();
        while (!currentString.equals(end))
        {
            currentInt = Integer.parseInt(currentString);
            sum = sum + currentInt;
            currentString = reader.readLine();
        }
        return sum;
    }
}
