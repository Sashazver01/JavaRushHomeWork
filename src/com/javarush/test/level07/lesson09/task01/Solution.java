package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<Integer> list20 = inputArrayListInt(20);
        ArrayList<Integer> listMultiplyTwo = getMultiplyNumberlist(list20, 2);
        ArrayList<Integer> listMultiplyTree = getMultiplyNumberlist(list20, 3);
        ArrayList<Integer> listNoMultiplyNumbers = new ArrayList<Integer>();
        listNoMultiplyNumbers.add(2);
        listNoMultiplyNumbers.add(3);
        ArrayList<Integer> listNoMultiplyTwoTree = getNoMultiplyNumberslist(list20, listNoMultiplyNumbers);
        printList(listMultiplyTree);
        printList(listMultiplyTwo);
        printList(listNoMultiplyTwoTree);

    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> inputArrayListInt(int count) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listInt = new ArrayList<Integer>();
        for (int i = 0; i < count; i++)
        {
            listInt.add(Integer.parseInt(reader.readLine()));
        }
        return listInt;
    }
    public static ArrayList<Integer> getMultiplyNumberlist(ArrayList<Integer> list, int number)
    {
        ArrayList<Integer> rezult = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i)%number ==0)
            {
                rezult.add(list.get(i));
            }
        }
        return rezult;
    }
    public static ArrayList<Integer> getNoMultiplyNumberslist(ArrayList<Integer> list, ArrayList<Integer> numbers)
    {
        ArrayList<Integer> rezult = new ArrayList<Integer>();
        boolean nomultiply;
        for (int i = 0; i < list.size(); i++)
        {
            nomultiply = true;
            for (int j = 0; j < numbers.size(); j++)
            {
                if ((list.get(i)%numbers.get(j) ==0))
                {
                    nomultiply =false;
                }
            }
            if (nomultiply)
            {
                rezult.add(list.get(i));
            }

        }
        return rezult;
    }


}
