package com.javarush.test.level15.lesson12.home04;

/**
 * Created by alexandr on 26.12.15.
 */
public class Earth implements Planet
{
    private static Earth Instance = new Earth();



    private Earth(){}

    public static Earth getInstance()
    {
        return Instance;
    }
}
