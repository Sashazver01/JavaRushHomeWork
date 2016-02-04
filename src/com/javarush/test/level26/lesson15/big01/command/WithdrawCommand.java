package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by alexandr on 16.01.16.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        Map<Integer, Integer> nominalMap;
        while(true)
        {
            ConsoleHelper.writeMessage("before");
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("specify.amount");
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage("specify.not.empty.amount");
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage("not.enough.money");
                continue;
            }
            try
            {
                nominalMap = currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("exact.amount.not.available");
                continue;
            }
            List<Integer> listNominal = new ArrayList<Integer>();
            listNominal.addAll(nominalMap.keySet());
            Collections.sort(listNominal);
            for (int i = listNominal.size()-1; i >=0 ; i--)
            {
                ConsoleHelper.writeMessage("    "+listNominal.get(i) + " - " + nominalMap.get(listNominal.get(i)));
            }
            break;
        }



    }
}
