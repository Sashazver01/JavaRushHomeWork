package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        String foname;
        String pasport;
        String id;
        String nation;
        Date DOB;
        int age;
        double weight;
        double height;
        boolean sex;

        public Human(String name, String foname, String pasport, String id, String nation, Date DOB, int age, double weight, double height) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
            this.DOB = DOB;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(String name, String foname, String pasport, String id, String nation, Date DOB, int age) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
            this.DOB = DOB;
            this.age = age;
        }

        public Human(String name, String foname,
                     String pasport, String id,
                     String nation, Date DOB,
                     int age, double weight,
                     double height, boolean sex) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
            this.DOB = DOB;
            this.age = age;
            this.weight = weight;

            this.height = height;
            this.sex = sex;
        }

        public Human(String name, String foname,
                     Date DOB, int age, double weight,
                     double height, boolean sex) {
            this.name = name;
            this.foname = foname;
            this.DOB = DOB;
            this.age = age;
            this.weight = weight;
            this.height = height;
            this.sex = sex;
        }

        public Human(String name, String foname) {
            this.name = name;
            this.foname = foname;
        }

        public Human(String name, String foname,
                     String pasport, String id,
                     String nation, Date DOB) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
            this.DOB = DOB;
        }

        public Human(String name, String foname, String pasport) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
        }

        public Human(String name, String foname, String pasport, String id, String nation) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
        }

        public Human(String name, String foname, String pasport, String id, String nation, Date DOB, int age, double weight) {
            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;
            this.nation = nation;
            this.DOB = DOB;
            this.age = age;
            this.weight = weight;
        }

        public Human(String name, String foname, String pasport, String id) {

            this.name = name;
            this.foname = foname;
            this.pasport = pasport;
            this.id = id;

        }

    }
}
