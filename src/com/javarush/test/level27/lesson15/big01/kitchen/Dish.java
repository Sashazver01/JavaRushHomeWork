package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

public enum Dish
{
    Fish, Steak, Soup, Juice, Water;

    public static String allDishesToString()
    {
        return values().length == 0 ? "" : Arrays.toString(values()).substring(1, Arrays.toString(values()).length() - 1);
    }
}