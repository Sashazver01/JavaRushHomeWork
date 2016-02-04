package com.javarush.test.level15.lesson12.home04;

/**
 * Created by alexandr on 26.12.15.
 */
public class Sun implements Planet
{
    private static Sun Instance = new Sun();



    private Sun(){}

    public static Sun getInstance()
    {
        return Instance;
    }
}
