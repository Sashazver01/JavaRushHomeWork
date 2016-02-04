package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by alexandr on 24.01.16.
 */
public class UndoAction extends AbstractAction
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.undo();
    }

    private View view;

    public UndoAction(View view)
    {
        this.view = view;
    }
}
