package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //на пишите тут ваш код
        int n = 5;
        ArrayList<Integer>  integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++)
        {
            integerArrayList.add(Integer.parseInt(reader.readLine()));
        }
        ArrayList<Integer> sortList = Solution.sort(integerArrayList);
        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }

    }
    public static ArrayList<Integer> sort(ArrayList<Integer> list)
    {   //ArrayList<Integer> sortList = (ArrayList<Integer>) list.clone();
        int buf = 0;
        for (int i = 0; i < list.size()-1; i++)
        {
            for (int j = i + 1; j < list.size(); j++)
            {
                if (list.get(i) > list.get(j))
                {
                    buf = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, buf);

                }

            }
        }
        return list;
    }
}
