package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileWriter outputStream = new FileWriter(fileName2);

        String currentNumber = "";
        String s = "";
        while (inputStream.available()> 0)
        {

            s = "" + (char)inputStream.read();
            if (" ".equals(s))
            {
                double number = Double.parseDouble(currentNumber);
                int numberInt = (int)Math.round(number);
                String numberString = "" + numberInt + " ";
                outputStream.write(numberString);
                currentNumber = "";

            }
            else
                currentNumber = currentNumber + s;
            if (inputStream.available() == 0)
            {
                double number = Double.parseDouble(currentNumber);
                int numberInt = (int)Math.round(number);
                String numberString = "" + numberInt + " ";
                outputStream.write(numberString);
                currentNumber = "";
            }


        }
        inputStream.close();
        outputStream.close();



    }
}
