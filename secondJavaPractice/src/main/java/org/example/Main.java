package org.example;
import java.util.Locale;
import java.util.Scanner;

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
