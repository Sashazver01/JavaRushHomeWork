package com.javarush.test.level19.lesson03.task04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scanner;

        public PersonScannerAdapter(final Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] data = scanner.nextLine().split(" ");
            String firstName = data[0];
            String midleName = data[1];
            String lastName = data[2];

            Calendar birthDate = new GregorianCalendar(Integer.parseInt(data[5]), Integer.parseInt(data[4])-1, Integer.parseInt(data[3]));
            return new Person(midleName,lastName,firstName,birthDate.getTime());
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
            this.close();
        }
    }
    public static void main(String[] args) throws IOException
    {
        String fileName = "/home/alexandr/Idea/ArhivJavaRush/JavaRushHomeWork/src/com/javarush/test/level19/lesson03/task04/test";
        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new FileInputStream(fileName)));

        Person person = adapter.read();
        System.out.println(person);
    }

}
