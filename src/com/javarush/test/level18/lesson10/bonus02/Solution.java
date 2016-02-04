package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> linesID = new ArrayList<>();
        ArrayList<String> linesData = new ArrayList<>();
        while (fileReader.ready())
        {
            String curendLine = fileReader.readLine();

            String id = curendLine.substring(0,8);
            linesData.add(curendLine);
            linesID.add(id);

        }
        fileReader.close();
        String newID = newId(linesID);

        String  newProductName  = AddProbel(args[1], 30);
        String  newPrice        = AddProbel(args[2], 8);
        String  newquantity     = AddProbel(args[3], 4);

        if ("-c".equals(args[0]))
        {

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < linesData.size(); i++)
            {
                fileWriter.write(linesData.get(i));
                fileWriter.write(System.getProperty("line.separator"));
            }
            String newLine = newID + newProductName + newPrice + newquantity;
            fileWriter.write(newLine);

            fileWriter.close();
        }


    }
    private static String newId(ArrayList<String> arrayList){
        if (arrayList.size()==0){
            return AddProbel("1",8);
        }
        String max1 = arrayList.get(0);
        max1 = max1.substring(0,max1.indexOf(" ".charAt(0)));
        int max = Integer.parseInt(max1);
        for (int i = 1; i < arrayList.size(); i++)
        {
            String curentIds = arrayList.get(i);
            int lastindex = curentIds.indexOf(" ".charAt(0));
            if (!(lastindex == -1)){
            curentIds = curentIds.substring(0,lastindex);
            }
            int curentId =Integer.parseInt(curentIds);
            if (max < curentId)
                max = curentId;

        }

        String res = "" + (max+1);
        res = AddProbel(res,8);
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
