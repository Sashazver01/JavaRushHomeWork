package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by alexandr on 17.01.16.
 */
public class LoginCommand implements Command
{
    private final String creditCardNumber = "123456789012";
    private final String pin = "1234";
    @Override
    public void execute() throws InterruptOperationException
    {

        String userCreditCardNumber = "";
        String userPin = "";
        while (!userCreditCardNumber.equals(creditCardNumber)
                && !userPin.equals(pin)){
            ConsoleHelper.writeMessage("Enter credit card number (12 digits) and pin (4 digits)");
            userCreditCardNumber = ConsoleHelper.readString();
            userPin = ConsoleHelper.readString();
            if (!userCreditCardNumber.matches("^[0-9]{12}$")){
                ConsoleHelper.writeMessage("Wrong card info");
                continue;
            }
            if(!userPin.matches("^[0-9]{4}$")){
                ConsoleHelper.writeMessage("Wrong card info");
                continue;
            }
            if (userCreditCardNumber.equals(creditCardNumber) || userPin.equals(pin)){
                ConsoleHelper.writeMessage("Access accepted");
            }
            else {
                ConsoleHelper.writeMessage("Access denied");
            }
        }
    }


}
