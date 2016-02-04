package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        ArrayList<String> linesData = new ArrayList<>();
        while (fileReader.ready())
        {
            String curendLine = fileReader.readLine();


            linesData.add(curendLine);
        }
        fileReader.close();
        String needID = args[1];
        needID = AddProbel(needID,8);
        int needLine = IndexNeedIDOnArray(linesData, needID);

        String comand = args[0];
        switch (comand){
            case "-u":
                String newProductName = AddProbel(args[2],30);
                String newPrice       = AddProbel(args[3],8);
                String newquantity    = AddProbel(args[4],4);
                String newLine = needID + newProductName + newPrice +newquantity;
                linesData.set(needLine,newLine);
                break;

            case "-d":
                linesData.remove(needLine);
                break;
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < linesData.size(); i++)
        {
            fileWriter.write(linesData.get(i));
            fileWriter.write(System.getProperty("line.separator"));
        }
        fileWriter.close();



    }
    private static int IndexNeedIDOnArray(ArrayList<String> list, String NeedID){
        int res = -1;

        for (int i = 0; i < list.size(); i++)
        {
            String currentID = list.get(i).substring(0,8);
            if (NeedID.equals(currentID)){
                res = i;
            }
        }
        return res;
    }
    private static String AddProbel(String s, int NedProbel){
        String res = "" + s;
        if (res.length()>NedProbel){
            return res.substring(0,NedProbel);
        }
        int needProbel = NedProbel - res.length();
        for (int i = 1; i <= needProbel; i++)
        {
            res = res + " ";
        }
        return res;
    }
}
