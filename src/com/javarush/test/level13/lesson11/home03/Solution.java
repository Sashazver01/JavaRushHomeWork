package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here

        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream;
        String inputFile = reader.readLine();
//        int i = 5;
        while (true)
        {
            try
            {
                inputStream = new FileInputStream(inputFile);
                break;

            }
            catch (Exception e)
            {
//                System.out.println("No");
                inputFile = reader.readLine();
//                i--;
            }
        }

        while (inputStream.available()>0)
        {
            int data = inputStream.read();
            char dataChar = (char)data;
            System.out.print(dataChar);
        }
        inputStream.close();
        reader.close();
    }
}
