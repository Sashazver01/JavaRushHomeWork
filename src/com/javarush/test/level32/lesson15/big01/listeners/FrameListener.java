package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by alexandr on 24.01.16.
 */
public class FrameListener extends WindowAdapter
{
    private View view;

    @Override
    public void windowClosing(WindowEvent e)
    {
        view.exit();
    }

    public FrameListener(View view)
    {
        this.view = view;
    }
}
