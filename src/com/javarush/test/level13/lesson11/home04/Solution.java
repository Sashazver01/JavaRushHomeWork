package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream;
        String outputFile = reader.readLine();
//        int i = 5;
        while (true)
        {
            try
            {
                outputStream = new FileOutputStream(outputFile);
                break;

            }
            catch (Exception e)
            {
//               System.out.println("No");
                outputFile = reader.readLine();
//                i--;
            }
        }
        String sum = "";

        String s = reader.readLine();
        while (!s.equals("exit"))
        {
            sum = sum + s + System.getProperty("line.separator");
            s = reader.readLine();
        }
        sum = sum + s + System.getProperty("line.separator");

//        System.out.println(sum);

        for (int i = 0; i < sum.length(); i++)
        {
            int data = (int)sum.charAt(i);
            outputStream.write(data);
        }
        reader.close();


    }
}
