package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    private  Solution(Object i) {}
    private  Solution(int i)   {}
    private  Solution(Integer i) {}

    protected Solution(char i){}
    protected Solution(Character i){}
    protected Solution(String i){}

    Solution(){}
    Solution(boolean i){}
    Solution(Boolean i){}

    public Solution(byte i){}
    public Solution(Byte i){}
    public Solution(short i){}


}

