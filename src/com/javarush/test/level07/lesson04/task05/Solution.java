package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] array20 = inputArrayInt(20);
        int[] array101 = new int[10];
        int[] array102 = new int[10];
        for (int i = 0; i < 10; i++)
        {
            array101[i] = array20[i];
        }
        int k = 0;

        for (int i = 10; i < array20.length; i++)
        {
            array102[k] = array20[i];
            k++;
        }

        k = 0;

        for (int i = 0; i < array102.length; i++)
        {
            System.out.println(array102[i]);
        }

    }
    public static int[] inputArrayInt(int count) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }
        return array;
    }
}
