package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "Zerg1";
        Zerg zerg2 = new Zerg();
        zerg2.name = "Zerg2";
        Zerg zerg3 = new Zerg();
        zerg3.name = "Zerg3";
        Zerg zerg4 = new Zerg();
        zerg4.name = "Zerg4";
        Zerg zerg5 = new Zerg();
        zerg5.name = "Zerg5";
        Zerg zerg6 = new Zerg();
        zerg6.name = "Zerg6";
        Zerg zerg7 = new Zerg();
        zerg7.name = "Zerg7";
        Zerg zerg8 = new Zerg();
        zerg8.name = "Zerg8";
        Zerg zerg9 = new Zerg();
        zerg9.name = "Zerg9";
        Zerg zerg10 = new Zerg();
        zerg10.name = "Zerg10";

        // протосы
        Protos protos1 = new Protos();
        protos1.name = "Protos1";
        Protos protos2 = new Protos();
        protos2.name = "Protos2";
        Protos protos3 = new Protos();
        protos1.name = "Protos3";
        Protos protos4 = new Protos();
        protos4.name = "Protos4";
        Protos protos5 = new Protos();
        protos5.name = "Protos5";

        // терраны
        Terran terran1 = new Terran();
        terran1.name = "Teran1";
        Terran terran2 = new Terran();
        terran2.name = "Teran2";
        Terran terran3 = new Terran();
        terran3.name = "Teran3";
        Terran terran4 = new Terran();
        terran4.name = "Teran4";
        Terran terran5 = new Terran();
        terran5.name = "Teran5";
        Terran terran6 = new Terran();
        terran6.name = "Teran6";
        Terran terran7 = new Terran();
        terran7.name = "Teran7";
        Terran terran8 = new Terran();
        terran8.name = "Teran8";
        Terran terran9 = new Terran();
        terran9.name = "Teran9";
        Terran terran10 = new Terran();
        terran10.name = "Teran10";
        Terran terran11 = new Terran();
        terran11.name = "Teran11";
        Terran terran12 = new Terran();
        terran12.name = "Teran12";
    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}