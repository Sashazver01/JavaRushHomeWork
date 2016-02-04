package com.javarush.test.level09.lesson11.home05;

import sun.util.BuddhistCalendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        char[] charsLine = line.toCharArray();
        ArrayList<Character>  lineVowels    = new ArrayList<Character>();
        ArrayList<Character>  lineNoVowels  = new ArrayList<Character>();
        char probel = " ".charAt(0);
        for (int i = 0; i < charsLine.length; i++)
        {
            if (isVowel(charsLine[i]))
            {
                lineVowels.add(charsLine[i]);
            }
            else
            {
                if (charsLine[i] != probel)
                    lineNoVowels.add(charsLine[i]);
            }
        }
        String vowels1 = "";
        for (int i = 0; i < lineVowels.size(); i++)
        {
            vowels1 = vowels1  + lineVowels.get(i) + " ";
        }
        String noVowels = "" ;
        for (int i = 0; i < lineNoVowels.size(); i++)
        {
            noVowels = noVowels  + lineNoVowels.get(i) + " ";
        }
        System.out.println(vowels1);
        System.out.println(noVowels);
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};


    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
