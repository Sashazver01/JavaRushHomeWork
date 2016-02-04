package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        if (args.length == 2)
        {
            String zipFileDestination = args[1];
            String fileDir = args[0];
            Map<String, ByteArrayOutputStream> map = new HashMap<>();
            File fileToWrite = new File(fileDir);

            try
                    (FileInputStream inputStream = new FileInputStream(zipFileDestination);
                     ZipInputStream zipInputStream = new ZipInputStream(inputStream))
            {
                ZipEntry zipEntry = null;
                while ((zipEntry = zipInputStream.getNextEntry()) != null)
                {
                    byte[] buffer = new byte[4];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (zipInputStream.read(buffer)!= -1)
                    {
                        byteArrayOutputStream.write(buffer);
                    }
                    map.put(zipEntry.getName(),byteArrayOutputStream);
                }
            }
            catch (IOException e)
            {}

            String fileToWriteName = fileToWrite.getName();
            try (FileInputStream fileInputStream = new FileInputStream(fileToWrite))
            {
                int length = fileInputStream.available();
                byte[] bytes = new byte[length];
                fileInputStream.read(bytes);
                ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream(length);
                byteArrayOutputStream.write(bytes);
                if (map.containsKey(fileToWriteName))
                {
                    map.put(fileToWrite.getName(), byteArrayOutputStream);
                } else
                {
                    map.put("new/" + fileToWrite.getName(), byteArrayOutputStream);
                }
            }
            catch (IOException e)
            {}
            //Перебираем все элементы и записываем их в архив
            try
                    (FileOutputStream fileOutputStream = new FileOutputStream(zipFileDestination);
                     ZipOutputStream zip = new ZipOutputStream(fileOutputStream))
            {
                for (Map.Entry<String, ByteArrayOutputStream> entry : map.entrySet())
                {
                    String name = entry.getKey();
                    ByteArrayOutputStream byteArrayOutputStream = entry.getValue();
                    zip.putNextEntry(new ZipEntry(name));
                    zip.write(byteArrayOutputStream.toByteArray());
                    zip.closeEntry();
                }
            }
            catch (IOException e)
            {}
        }
    }
}
