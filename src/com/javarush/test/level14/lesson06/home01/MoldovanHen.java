package com.javarush.test.level14.lesson06.home01;

/**
 * Created by alexandr on 24.12.15.
 */
public class MoldovanHen extends Hen implements Country
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 5;
    }
    @Override
    String getDescription()
    {
        return super.getDescription()
                +  " Моя страна - "
                + MOLDOVA
                + ". Я несу "
                + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }
}
