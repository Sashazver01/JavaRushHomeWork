package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1


        {
        //создаем объект, пункт 2
            while (true)
            {
                key = reader.readLine();
                int a = 0;
                if ("user".equals(key))
                    a = 1;
                if ("looser".equals(key))
                    a = 2;
                if ("coder".equals(key))
                    a = 3;
                if ("proger".equals(key))
                    a = 4;
                if (a == 0)
                    break;
                switch (a)
                {
                    case 1:
                        person = new Person.User();
                        break;
                    case 2:
                        person = new Person.Looser();
                        break;
                    case 3:
                        person = new Person.Coder();
                        break;
                    case 4:
                        person = new Person.Proger();
                        break;
                    default:
                        break;
                }


                doWork(person); //вызываем doWork
            }


        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if (person instanceof Person.Looser)
            ((Person.Looser) person).doNothing();
        if (person instanceof Person.Coder)
            ((Person.Coder) person).coding();
        if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();


    }
}
