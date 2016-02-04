package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{

    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        String name;
        int y;
        int m;
        int d;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (true)
        {
            name = reader.readLine();
        }
        if (true)
        {
            y = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            d = Integer.parseInt(reader.readLine());
        }
        System.out.println("Меня зовут "+ name);
        System.out.println("Я родился " + d + "." + m + "." + y);
    }

    public class Men
    {
        private String name;
        private int y;
        private int m;
        private int d;

        public  void  initialize(boolean name, boolean date)throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            if (name)
            {
                this.name = reader.readLine();
            }
            if (date)
            {
                this.y = Integer.parseInt(reader.readLine());
                this.m = Integer.parseInt(reader.readLine());
                this.d = Integer.parseInt(reader.readLine());
            }
        }

        public Men()
        {

        }

        public  void bePrezented()
        {
            System.out.println("Меня зовут "+ this.name);
            System.out.println("Я родился " + this.d + "." + this.m + "." + this.y);
        }
    }
}
