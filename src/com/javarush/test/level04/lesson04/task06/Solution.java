package com.javarush.test.level04.lesson04.task06;

/* День недели
Ввести с клавиатуры номер дня недели, в зависимости от номера вывести название «понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
если введен номер больше или меньше 7 – вывести «такого дня недели не существует».
Пример для номера 5:
пятница
Пример для номера 10:
такого дня недели не существует
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int dayInt = inputInt();
        String dayString = dayIntToString(dayInt);
        System.out.println(dayString);

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
    private static String dayIntToString(int day)
    {
        String s = "";
        switch (day)
        {
            case 1:
                s = "понедельник";
                break;
            case 2:
                s = "вторник";
                break;
            case 3:
                s = "среда";
                break;
            case 4:
                s = "четверг";
                break;
            case 5:
                s = "пятница";
                break;
            case 6:
                s = "суббота";
                break;
            case 7:
                s = "воскресенье";
                break;
            default:
                s = "такого дня недели не существует";

        }
        return s;
    }
}