package com.javarush.test.level22.lesson18.big01;

/**
 * Created by alexandr on 09.01.16.
 */
public class Figure
{
    private int x;
    private int y;
    private int[][]matrix;

    public Figure(int x, int y, int[][] matrix)
    {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void left()
    {

    }
    public void right()
    {

    }
    public void down()
    {

    }
    public void up()
    {

    }
    public void downMaximum()
    {

    }

    public boolean isCurrentPositionAvailable()
    {
        return true;
    }
    public void landed()
    {

    }


    public void rotate()
    {
    }
}
