package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!"exit".equals(fileName))
        {
            ReadThread currentThreadRead = new ReadThread(fileName);
            currentThreadRead.start();
            currentThreadRead.join();
            fileName = reader.readLine();
        }
        reader.close();

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;

        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try{
                FileInputStream fileReader = new FileInputStream(fileName);
                HashMap<Integer, Integer> map =  new HashMap<Integer, Integer>();

                while (fileReader.available() >0)
                {
                    int data = fileReader.read();
                    map.put(data, (map.get(data)==null)?1:map.get(data)+1);
                }
                fileReader.close();
                int maxCount = Integer.MIN_VALUE;
                int maxData = 0;

                for (Map.Entry<Integer,Integer> pair : map.entrySet())
                {
                    if (maxCount < pair.getValue()){
                        maxCount = pair.getValue();
                        maxData = pair.getKey();
                    }
                }
                if (maxCount != Integer.MIN_VALUE && maxData != 0) {
                    synchronized (resultMap){
                        resultMap.put(fileName, maxData);
                    }
                }



            }catch (Exception e){}


        }
    }
}
