package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));

        BufferedWriter  fileWriter =new BufferedWriter(new FileWriter(fileName2));
        String text = "";
        String newtext = "";
        while (fileReader.ready()){
            text = text + fileReader.readLine();
        }
        fileReader.close();
        text = text.replaceAll("\n"," ");
        String [] data = text.split(" ");
        for (int i = 0; i < data.length; i++)
        {
            String s = data[i].trim();
            if (stringHaveNubbers(s)){
                newtext = newtext + s + " ";
            }
        }
        newtext = newtext.trim();
        fileWriter.write(newtext);
        fileWriter.close();
    }




    public static boolean stringHaveNubbers(String s){
        for (int i = 0; i < s.length(); i++)
        {
            if (checkString(s.charAt(i)+""))
                return true;
        }
        return false;
    }
    public static boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        int i = 0;
        if (string.charAt(0) == '-') {
            if (string.length() == 1) {
                return false;
            }
            i = 1;
        }

        char c;
        for (; i < string.length(); i++) {
            c = string.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
}
