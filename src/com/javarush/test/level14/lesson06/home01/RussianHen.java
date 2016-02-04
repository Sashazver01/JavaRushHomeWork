package com.javarush.test.level14.lesson06.home01;

/**
 * Created by alexandr on 24.12.15.
 */
public class RussianHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 12;
    }
    @Override
    String getDescription()
    {
        return super.getDescription()
                +  " Моя страна - "
                + RUSSIA
                + ". Я несу "
                + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }
}
