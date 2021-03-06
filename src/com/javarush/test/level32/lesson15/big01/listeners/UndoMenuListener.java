package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;


/**
 * Created by alexandr on 24.01.16.
 */
public class UndoMenuListener implements MenuListener
{
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;


    @Override
    public void menuSelected(MenuEvent e)
    {
        boolean canUndo = view.canUndo();
        undoMenuItem.setEnabled(canUndo);
        boolean canRedo = view.canRedo();
        redoMenuItem.setEnabled(canRedo);
    }

    @Override
    public void menuDeselected(MenuEvent e)
    {

    }

    @Override
    public void menuCanceled(MenuEvent e)
    {

    }

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem)
    {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
}
