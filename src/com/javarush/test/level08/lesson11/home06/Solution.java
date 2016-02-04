package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.lang.management.MemoryUsage;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> noChildren =  new ArrayList<Human>();
        Human son1      = new Human("son1",true,19,noChildren);
        Human son2      = new Human("son2",true,21,noChildren);
        Human doughter  = new Human("doughter",false,21,noChildren);
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(son1);
        children.add(son2);
        children.add(doughter);
        Human father    = new Human("father",true,40,children);
        Human mather    = new Human("mather",false,41,children);
        ArrayList<Human> fatherchildren = new ArrayList<Human>();
        fatherchildren.add(father);
        ArrayList<Human> matherChildren = new ArrayList<Human>();
        matherChildren.add(mather);

        Human grendfather1 = new Human("grendfater1", true ,60, fatherchildren);
        Human grendmather1 = new Human("grendmather1", false ,59, fatherchildren);
        Human grendfather2 = new Human("grendfater2", true ,60, matherChildren);
        Human grendmather2 = new Human("grendmather2", false ,59, matherChildren);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(doughter);
        System.out.println(father);
        System.out.println(mather);
        System.out.println(grendfather1);
        System.out.println(grendmather1);
        System.out.println(grendfather2);
        System.out.println(grendmather2);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
