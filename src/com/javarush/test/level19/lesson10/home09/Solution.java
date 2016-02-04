package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {


        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream failStream = new PrintStream(byteArrayOutputStream);
        System.setOut(failStream);

        testString.printSomething();

        System.setOut(printStream);

        String result = byteArrayOutputStream.toString();
        String[] data = result.split("\n");
        int count =0;
        String newResult = "";
        for (int i = 0; i <data.length; i++)
        {
            count++;
            newResult = newResult + data[i] + "\n";
            if (count == 2)
            {
                newResult = newResult + "JavaRush - курсы Java онлайн" + "\n";
                count =0;
            }

        }
        newResult = newResult.substring(0,newResult.length()-1);

        System.out.println(newResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
