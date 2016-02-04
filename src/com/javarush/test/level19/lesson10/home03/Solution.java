package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready())
        {
            String line = fileReader.readLine();
            String[] data = line.split(" ");
            int nameLegnt = data.length -3;
            String name = "";
            for (int i = 0; i < nameLegnt; i++)
            {
                name = name + data[i]+ " ";
            }
            name = name.trim();
            Calendar birthDate = new GregorianCalendar(
                    Integer.parseInt(data[nameLegnt+2]),
                    Integer.parseInt(data[nameLegnt+1])-1,
                    Integer.parseInt(data[nameLegnt]));
            Person person = new Person(name,birthDate.getTime());
            PEOPLE.add(person);
        }
        fileReader.close();
    }

}
