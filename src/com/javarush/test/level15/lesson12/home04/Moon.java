package com.javarush.test.level15.lesson12.home04;

/**
 * Created by alexandr on 26.12.15.
 */
public class Moon implements Planet
{
    private static Moon Instance = new Moon();



    private Moon(){}

    public static Moon getInstance()
    {
        return Instance;
    }
}
