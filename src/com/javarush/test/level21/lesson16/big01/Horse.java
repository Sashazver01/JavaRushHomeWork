package com.javarush.test.level21.lesson16.big01;

/**
 * Created by alexandr on 07.01.16.
 */
public class Horse
{
    private String name;
    private double speed;
    private double distance;



    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()

    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public Horse(String name, double speed, double distance)
    {

        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void run()
    {

    }
    public void move()
    {
        distance = distance + Math.random()*speed;
    }
    public void print()
    {
        String s = ".";
        String path = "";
        for (int i = 0; i < distance; i++)
        {
            path = path + s;
        }

        System.out.println(path+name);
    }
}
