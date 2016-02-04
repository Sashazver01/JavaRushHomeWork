package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        public A clone() throws CloneNotSupportedException{
            return new A(this.i,this.j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone() throws CloneNotSupportedException{

            return new C(this.getI(),this.getJ(),this.getName());
        }
    }

    public static void main(String[] args)throws CloneNotSupportedException
    {
        A a = new A(1,1);
        B b = new B(2,2,"B");
        C c = new C(3,3,"c");

        A a1 = a.clone();
//        B b1 = b.clone();
        C c1 = c.clone();

    }
}