package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код

    double top;
    double left;
    double widht;
    double height;

    public Rectangle(double top, double left, double widht, double height) {
        this.top = top;
        this.left = left;
        this.widht = widht;
        this.height = height;
    }

    public Rectangle(double top, double left) {
        this.top = top;
        this.left = left;
        this.height = 0;
        this.widht  = 0;
    }

    public Rectangle(double top, double left, double widht) {
        this.top = top;
        this.left = left;
        this.widht = widht;
        this.height = this.widht;

    }
    public Rectangle(Rectangle b) {
        this.top = b.top;
        this.left = b.left;
        this.widht = b.widht;
        this.height = b.height;
    }
}
