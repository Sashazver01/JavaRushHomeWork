package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileName1 =  args[0];

        String fileName2 = args[1];

        try( FileInputStream reader = new FileInputStream(fileName1);
            FileOutputStream writer = new FileOutputStream(fileName2))
        {
            byte[] data = new byte[reader.available()];
            int count = reader.read(data, 0, data.length);


            Charset windows1251 = Charset.forName("Windows-1251");
            Charset utf8 = Charset.forName("UTF-8");
            String winwow = new String(data, utf8);
            data = winwow.getBytes(windows1251);
            writer.write(data,0,data.length);
        }


    }
}
