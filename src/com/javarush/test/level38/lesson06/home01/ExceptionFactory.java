package com.javarush.test.level38.lesson06.home01;

public class ExceptionFactory {
    public static Throwable getException(Enum message)
    {
        if (message != null)
        {
            String msg = message.name().charAt(0) + "" + message.name().substring(1).toLowerCase().replaceAll("_", " ");

            if (message instanceof ExceptionApplicationMessage)
            {
                return (new Exception(msg));
            }
            if (message instanceof ExceptionDBMessage)
            {
                return (new RuntimeException(msg));
            }
            if (message instanceof ExceptionUserMessage)
            {
                return (new Error(msg));
            }
            return new IllegalArgumentException();
        }

        return new IllegalArgumentException();
    }
}