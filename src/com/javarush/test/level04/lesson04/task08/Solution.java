package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            double a = Double.parseDouble(reader.readLine());
            double b = Double.parseDouble(reader.readLine());
            double c = Double.parseDouble(reader.readLine());
            if (maybyItIsTriangle(a, b, c))
            {
                System.out.println("Треугольник существует.");
            }
            else
            {
                System.out.println("Треугольник не существует.");

            }




    }

    public static boolean maybyItIsTriangle(double a, double b, double c)
    {
        boolean rezult = true;
        if(((a + b) <= c) || ((a + c) <= b)  ||  ((b + c) <= a))
        {
            rezult = false;
        }
        return rezult;
    }
}