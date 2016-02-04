package com.javarush.test.level04.lesson04.task09;

/* Светофор
Работа светофора для пешеходов запрограммирована следующим образом: в начале каждого часа в течение трех минут горит зеленый сигнал,
затем в течение одной минуты — желтый, а потом в течение одной минуты — красный, затем опять зеленый горит три минуты и т. д.
Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
Определить, сигнал какого цвета горит для пешеходов в этот момент.
Результат вывести на экран в следующем виде:
"зеленый" - если горит зеленый цвет, "желтый" - если горит желтый цвет, "красный" - если горит красный цвет.
Пример для числа 2.5:
зеленый
Пример для числа 3:
желтый
Пример для числа 4:
красный
Пример для числа 5:
зеленый
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double time =  Double.parseDouble(reader.readLine());
        String colour = currenrColourForTime(time);
        System.out.println(colour);
    }
    private static String currenrColourForTime(double time)
    {
        String rezult = "";
        double timePeriod = time % 5.0;
        if ((timePeriod >= 0) && (timePeriod < 3))
        {
            rezult = "зеленый";
        }
        if ((timePeriod >= 3) && (timePeriod < 4))
        {
            rezult = "желтый";
        }
        if ((timePeriod >= 4) && (timePeriod < 5))
        {
            rezult = "красный";
        }

        return rezult;
    }

}