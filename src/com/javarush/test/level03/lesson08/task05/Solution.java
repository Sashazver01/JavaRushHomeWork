package com.javarush.test.level03.lesson08.task05;

/* Чистая любовь
Ввести с клавиатуры три имени, вывести на экран надпись:
name1 + name2 + name3 = Чистая любовь, да-да!
Пример: Вася + Ева + Анжелика = Чистая любовь, да-да!
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();
        System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");


    }
}