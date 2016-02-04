package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.Arrays;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите тут ваш код
        int n = Integer.parseInt(reader.readLine());
        while (!(n>0)){
            n = Integer.parseInt(reader.readLine());
        }
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]= Integer.parseInt(reader.readLine());
        }
        maximum = a[0];
        for (int i = 1; i < n; i++) {
            if (maximum<a[i]){
                maximum=a[i];
            }
        }
        //System.out.println(maximum);




        System.out.println(maximum);
    }

}
