package com.javarush.test.level26.lesson15.big01;



import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by alexandr on 16.01.16.
 */
public class ConsoleHelper

{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException{
        String res = "";
        try
        {
            res = reader.readLine();
            if ("EXIT".equals(res.toUpperCase())){
                  throw new InterruptOperationException();
            }

        }catch (IOException e ){}
        return res;
    }
    public static String askCurrencyCode() throws InterruptOperationException
    {
        writeMessage("введите код валюты");
        String cod = readString();
        while (!(cod.length() == 3)){
            writeMessage("invalid.data");
            cod = readString();
        }
        cod = cod.toUpperCase();
        return cod;

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("введите номинал и количество");
        String line = "";
        int nominal;
        int count;
        line = readString();
        String[] data = line.split(" ");
        while (true)
        {
            try
            {
                nominal = Integer.parseInt(data[0]);
                count = Integer.parseInt(data[1]);
            }
            catch (Exception e){
                writeMessage("invalid.data");
                continue;
            }
            if (nominal <= 0 || nominal <= 0 || data.length > 2)
            {
                writeMessage("invalid.data");
                continue;
            }
            break;
        }
        return data;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage("введите код операции ");
        while (true)
        {
            String line = readString();
            if (checkWithRegExp(line))
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(line));
            else
                writeMessage("invalid.data");
        }
    }
    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }
}
