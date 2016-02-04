package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
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
    double width;
    double height;

    public void initialize(double top, double left, double width, double height) {
        this.top    = top;
        this.left   = left;
        this.width  = width;
        this.height = height;
    }

    public void initialize(double top, double left) {
        this.top    = top;
        this.left   = left;
        this.height = 0;
        this.width  = 0;
    }

    public void initialize(double top, double left, double width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height =this.width;
    }

    public void initialize(Rectangle b) {
        this.top    = b.top;
        this.height = b.height;
        this.width  = b.width;
        this.left   = b.left;
    }

}
