package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alexandr on 19.01.16.
 */
public class MyThread extends Thread
{
    private static AtomicInteger currentPriority = new AtomicInteger(1);
    public MyThread()
    {
        init();
    }

    public MyThread(Runnable target)
    {
        super(target);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        init();
    }

    public MyThread(String name)
    {
        super(name);
        init();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        init();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        init();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        init();
    }

    private void init(){
        if (currentPriority.get() > Thread.MAX_PRIORITY){
            currentPriority.set(1);
        }
        this.setPriority(currentPriority.get());
        currentPriority.set(currentPriority.get()+1);
    }

}
