package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Сергей");
        map.put("Сидоров","Алексей");
        map.put("Тимонин","Алексей");
        map.put("Петренко","Федор");
        map.put("Крехов","Андрей");
        map.put("Королько","Григорий");
        map.put("Роецки","Алексей");
        map.put("Удалов","Артем");
        map.put("Тихонов","Павел");
        map.put("Поджогсараев","Разносустоев");
        return  map;


    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        ArrayList<String> arrayValue = new ArrayList<String>();
        arrayValue.addAll(map.values());
        int coutString ;
        String currentString;
        for (int i = 0; i < arrayValue.size()-1; i++)
        {
            coutString = 1;
            currentString = arrayValue.get(i);
            for (int j = i+1; j < arrayValue.size(); j++)
            {
                if (currentString.equals(arrayValue.get(j)))
                {
                    coutString++;
                }
            }
            if (coutString>1)
            {
                removeItemFromMapByValue(map,currentString);
            }
        }


    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        HashMap<String,String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " - " + pair.getValue() );
        }
    }
}
