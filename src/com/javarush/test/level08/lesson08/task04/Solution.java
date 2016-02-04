package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 1 1981"));
        map.put("Stallone2", new Date("JUNE 1 1982"));
        map.put("Stallone3", new Date("JUNE 1 1983"));
        map.put("Stallone4", new Date("JUNE 1 1984"));
        map.put("Stallone5", new Date("APRIL 1 1985"));
        map.put("Stallone6", new Date("MAY 1 1986"));
        map.put("Stallone7", new Date("MAY 1 1987"));
        map.put("Stallone8", new Date("MAY 1 1988"));
        map.put("Stallone9", new Date("MAY 1 1989"));
        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();
        int currentMaunt;
        while (iterator.hasNext())
        {
            currentMaunt = iterator.next().getValue().getMonth();
//            System.out.println(currentMaunt);
            if ( (currentMaunt == 5)||(currentMaunt == 6)||(currentMaunt == 7))
            {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String,Date> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " --- " +pair.getValue());
        }
    }
}
