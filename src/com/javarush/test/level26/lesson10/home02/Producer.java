package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by alexandr on 18.01.16.
 */
public class Producer implements Runnable

{
    protected ConcurrentHashMap<String, String> map;

    @Override
    public void run()
    {
        try {
            int i = 1;
            while (true) {
                System.out.println("Some text for "+i++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }
}
