package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] res = new Solution[2];
        res[0] =  new Solution();
        res[0].innerClasses[0] = res[0].new InnerClass();
        res[0].innerClasses[1] = res[0].new InnerClass();
        res[1] =  new Solution();
        res[1].innerClasses[0] = res[1].new InnerClass();
        res[1].innerClasses[1] = res[1].new InnerClass();
        return res;
    }
}
