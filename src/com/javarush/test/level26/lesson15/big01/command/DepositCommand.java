package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by alexandr on 16.01.16.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String cod = ConsoleHelper.askCurrencyCode();
        String[] data = ConsoleHelper.getValidTwoDigits(cod);
        CurrencyManipulator manipulator =  CurrencyManipulatorFactory.getManipulatorByCurrencyCode(cod);
        try
        {
            manipulator.addAmount(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
        }catch (Exception e){}
    }
}
