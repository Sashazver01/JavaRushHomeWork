package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by alexandr on 16.01.16.
 */
class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("вы действительно хотите выйти?");
        String res = ConsoleHelper.readString();
        if ("y".equals(res)){
            ConsoleHelper.writeMessage("Ну пока, тогда");
        }
    }
}
