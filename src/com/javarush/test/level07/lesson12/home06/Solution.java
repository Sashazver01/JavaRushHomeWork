package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandfather1    = new Human("Дедушка1", true, 69, null, null);
        Human grandfather2    = new Human("Дедушка2", true, 69, null, null);
        Human grandmather1    = new Human("Бабушка1", false, 69, null, null);
        Human grandmather2    = new Human("Бабушка2", false, 69, null, null);
        Human father        = new Human("Отец", true , 45, grandfather1, grandmather1);
        Human mather        = new Human("Мать", false, 46, grandfather2, grandmather2);
        Human son1          = new Human("Сын1", true, 20, father, mather);
        Human son2          = new Human("Сын2", true, 22, father, mather);
        Human doughter      = new Human("Дочь", false, 19, father, mather);
        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmather1);
        System.out.println(grandmather2);
        System.out.println(father);
        System.out.println(mather);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(doughter);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
