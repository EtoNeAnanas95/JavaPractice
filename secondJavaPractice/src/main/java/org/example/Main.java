package org.example;
import java.util.Locale;
import java.util.Scanner;
/*
TODO:
 Создать приложение на Java, которое будет вычислять расстояние между двумя географическими координатами на земной поверхности с использованием библиотеки Math.
 Пользователь должен иметь возможность ввести две пары географических координат: широту и долготу первой точки, а затем широту и долготу второй точки. Координаты должны быть введены в градусах.
 Формулу для вычисления расстояния между двумя точками на поверхности сферы можете использовать любую. Например, можете использовать формулу гаверсинусов, или ту, которая вам больше подходит.
 Приложение должно выводить расстояние между двумя точками в километрах.
 Радиус земли должен быть задан в виде константы.
 Результат вычисления должен быть +- равен тому, что выводится в онлайн-калькуляторах, например этом: https://geleot.ru/technology/navigation/coordinate_distance?ysclid=ls8mkj9sik192987496
 */

public class Main {
    public static Scanner sc = new Scanner(System.in);
    final static float earthRadius = 6378.1F;

    public static void main(String[] args) {
        while (true) {
            sc.useLocale(Locale.ENGLISH);
            double firstLongitude, firstLatitude, secondLongitude, secondLatitude;

            System.out.println("\u001B[34m(Если вы скопировали координаты из яндекс карт, то долгота -- это первое число из скпоованной вами пары чисел)\u001B[0m");
            System.out.println("Введите долготу первой точки на карте: ");
            firstLatitude = sc.nextDouble();

            System.out.println("Введите широту первой точки на карте: ");
            firstLongitude = sc.nextDouble();

            System.out.println("Введите долготу второй точки на карте: ");
            secondLatitude = sc.nextDouble();

            System.out.println("Введите широту второй точки на карте: ");
            secondLongitude = sc.nextDouble();

            double distance = earthRadius * 2 *
                    Math.asin(Math.sqrt(Math.pow(Math.sin(Math.toRadians((secondLatitude - firstLatitude) / 2)), 2)
                    + Math.cos(Math.toRadians(firstLatitude)) *
                    Math.cos(Math.toRadians(secondLatitude)) *
                    Math.pow(Math.sin(Math.toRadians((secondLongitude - firstLongitude) / 2)), 2)));

            System.out.print("\u001B[32m Расстояние между координами " + firstLatitude + " " + firstLongitude + " и " + secondLatitude + " " + secondLongitude + " = ");
            System.out.println(distance);
            clearScreen();
        }
    }
    public static void clearScreen() {
        sc.next();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}