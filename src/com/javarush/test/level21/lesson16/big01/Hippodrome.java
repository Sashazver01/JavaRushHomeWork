package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by alexandr on 07.01.16.
 */
public class Hippodrome
{
    private   ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public  ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException
    {
        Hippodrome hippodrome = new Hippodrome();
        game = hippodrome;

        Horse horse1 = new Horse("Name1",3,0);
        Horse horse2 = new Horse("Name2",3,0);
        Horse horse3 = new Horse("Name3",3,0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();


        game.printWinner();

    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            this.move();
            this.print();
            Thread.sleep(500);
        }
    }
    public void move()
    {
        ArrayList<Horse> horses =  this.getHorses();
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).move();
        }
    }
    public void print()
    {
        ArrayList<Horse> horses =  this.getHorses();
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
        }
        System.out.println("");
        System.out.println("");
    }

    public Horse getWinner()
    {
        ArrayList<Horse>  horses = this.getHorses();
        double maxDistance = 0;
        Horse winner = null;
        Horse currentHorse;
        for (int i = 0; i < horses.size(); i++)
        {
            currentHorse = horses.get(i);
            if (maxDistance< currentHorse.getDistance()){
                maxDistance = currentHorse.getDistance();
                winner = currentHorse;
            }

        }
        return winner;
    }
    public void printWinner()
    {
        Horse winer = this.getWinner();
        System.out.println("Winner is " + winer.getName() + "!");
    }
}
