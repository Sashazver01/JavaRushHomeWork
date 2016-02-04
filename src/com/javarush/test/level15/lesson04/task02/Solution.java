package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        printMatrix(2, 3, "8");
        printMatrix(true);
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(Integer m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(int m, Integer n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }


    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, Integer n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(Integer m, Integer n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int NXN, String value)
    {
        System.out.println("квадратная матрица стрингов");
        printMatrix(NXN,NXN,value);
    }
    public static void printMatrix(Integer NXN, String value)
    {
        System.out.println("Integer");
        printMatrix(NXN,value);
    }
    public static void printMatrix(boolean matrixNnaN)throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (matrixNnaN)
        {
            int NXN = Integer.parseInt(reader.readLine());
            String value = reader.readLine();
            printMatrix(NXN,value);
        }
        else
        {
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            String value = reader.readLine();
            printMatrix(n, m, value);
        }

    }
}
