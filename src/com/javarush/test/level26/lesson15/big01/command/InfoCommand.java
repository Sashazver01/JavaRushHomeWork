package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by alexandr on 16.01.16.
 */
class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean ismoney = false;
        for(CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if (manipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                if (manipulator.hasMoney())
                    ismoney = true;
            }
        }
        if (!ismoney)
            ConsoleHelper.writeMessage("No money available.");

    }
}
