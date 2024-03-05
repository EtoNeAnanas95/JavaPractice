package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[36m Введите число: \u001B[0m");
        int a = sc.nextInt();
        System.out.println("\u001B[36m Введите число: \u001B[0m");
        int b = sc.nextInt();
        System.out.println("\u001B[36m Введите число: \u001B[0m");
        int c = sc.nextInt();

        analization(a, b, c);
    }

    public static void analization(int a, int b, int c) {
        if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) System.out.println("\u001B[32m[a, b и c являются сторонами прямоугольного треугольника]");
        else if (a == b || b == c || c == a) System.out.println("\u001B[32m[a, b и c являются сторонами равнобедренного треугольника]");
        else if (a == b && b == c) System.out.println("\u001B[32m[a, b и c являются сторонами равностороннего треугольника]");
        else if (a + b <= c || b + c <= a || c + a <= b) System.out.println("\u001B[32m[a, b и c не являются сторонами треугольника]");
        else System.out.println("\u001B[32m[a, b и c являются сторонами обычного треугольника]");
    }
}