package com.javarush.test.level14.lesson08.bonus01;

import java.awt.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] array = new int[1];
            for (int i = 0; i < 10; i++)
            {
                int a = array[i];
            }
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int  a = Integer.parseInt("sfg");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream inputStream = new FileInputStream("dsfgb");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        exceptions.add(new FileAlreadyExistsException("sdvf"));
        exceptions.add(new FontFormatException("sdvf"));
        exceptions.add(new IndexOutOfBoundsException("sdvf"));
        exceptions.add(new EmptyStackException());
        exceptions.add(new IOException());
        exceptions.add(new InterruptedException());

    }
}
