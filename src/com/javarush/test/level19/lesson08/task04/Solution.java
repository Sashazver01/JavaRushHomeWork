package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
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

        String newText = byteArrayOutputStream.toString();

        System.setOut(printStream);

        //newText = newText.replaceAll("te", "??");

        String[] data = newText.split(" ");
        int number1 = Integer.parseInt(data[0]);
        int number2 = Integer.parseInt(data[2]);
        int result = 0;
        String comand = data[1];
        switch (comand){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
        }
        newText = newText.replaceAll("\n","");
        newText = newText + result;


        System.out.println(newText);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

