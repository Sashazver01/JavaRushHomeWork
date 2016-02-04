package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static String getPartOfString(String string) throws TooShortStringException{
        try
        {
            int probel1 = string.indexOf(" ");
            int probel4 = string.indexOf(" ", string.indexOf(" ", string.indexOf(" ", string.indexOf(" ", probel1+1)+1)+1)+1);
             String res = string.substring(probel1+1,probel4);
            return res;
        }catch (Exception e){
            throw new TooShortStringException();
        }


    }

    public static class TooShortStringException extends Exception{
    }
}
