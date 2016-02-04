package com.javarush.test.level15.lesson12.home05;

import java.util.Objects;

/**
 * Created by alexandr on 26.12.15.
 */
public class SubSolution extends Solution
{
    private  SubSolution(Object i) {}
    private  SubSolution(int i)   {}
    private  SubSolution(Integer i) {}

    protected SubSolution(char i)
    {
        super(i);
    }

    protected SubSolution(Character i)
    {
        super(i);
    }

    protected SubSolution(String i)
    {
        super(i);
    }

     SubSolution()
    {
    }

     SubSolution(boolean i)
    {
        super(i);
    }

     SubSolution(Boolean i)
    {
        super(i);
    }

    public SubSolution(byte i)
    {
        super(i);
    }

    public SubSolution(Byte i)
    {
        super(i);
    }

    public SubSolution(short i)
    {
        super(i);
    }
}
