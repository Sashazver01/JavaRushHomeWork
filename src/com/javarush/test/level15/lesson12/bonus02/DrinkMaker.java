package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by alexandr on 26.12.15.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();

    abstract void putIngredient();

    abstract void pour();

    void makeDrink()
    {
        this.getRightCup();
        this.putIngredient();
        this.pour();
    }
}
