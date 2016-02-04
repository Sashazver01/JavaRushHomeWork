package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator  implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void start(String threadName)
    {
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
    }

    @Override
    public void run() {
        try
        {
            while (true)
            {
                System.out.println(thread.getName());
                thread.sleep(100);

            }
        }catch (InterruptedException e ){}
    }
    @Override
    public void stop()
    {
        thread.interrupt();
    }


}
