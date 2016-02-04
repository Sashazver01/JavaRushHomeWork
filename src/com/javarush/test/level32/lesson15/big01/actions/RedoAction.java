package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by alexandr on 24.01.16.
 */
public class RedoAction extends AbstractAction
{
    private View view;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        view.redo();
    }

    public RedoAction(View view)
    {
        this.view = view;
    }
}
