package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args)
    {
       String[] strings = getTokens("level22.lesson13.task01", ".");
        for (int i = 0; i < strings.length; i++)
        {
            System.out.println(strings[i]);
        }
    }
}
