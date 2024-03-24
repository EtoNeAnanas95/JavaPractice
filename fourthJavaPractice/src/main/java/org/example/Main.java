package org.example;

import java.util.*;

public class Main {
    private static Scanner _sc = new Scanner(System.in);
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CLEAR_CONSOLE = "\033[H\033[2J";

    public static void main(String[] args) {
        ArrayList<String[]> OrdersColumns = new ArrayList<>();
        String[] watchCompanies = {"Rolex", "Omega", "Richard Mille", "Patek Philippe", "Swatch", "Casio"};
        String[][] watchModels = new String[][] {
                {watchCompanies[0], "Submariner", "Daytona"}, //Rolex
                {watchCompanies[1], "Speedmaster", "Seamaster"}, //Omega
                {watchCompanies[2], "RM 011", "RM 035"}, //Richard Mille
                {watchCompanies[3], "Nautilus", "Calatrava"}, //Patek Philippe
                {watchCompanies[4], "Sistem51", "Irony"}, //Swatch
                {watchCompanies[5], "G-Shock", "Edifice"}, //Casio
        };
        ArrayList<String[]> Orders = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int a = ChooseWatchFirm(watchCompanies);
            String selectedWatchFirm = watchCompanies[a];
            String selectedWatchModel = ChooseModel(watchModels[a]);
            _sc.nextLine();
            System.out.println(ANSI_YELLOW + "Введите количество часов к покупке: " + ANSI_RESET);
            String countItem = _sc.nextLine();
            //_sc.nextLine();
            System.out.println(ANSI_YELLOW + "Введите ФИО: " + ANSI_RESET);
            String fullName = _sc.nextLine();
            //_sc.nextLine();
            System.out.println(ANSI_YELLOW + "Введите email: " + ANSI_RESET);
            String email = _sc.nextLine();
            //_sc.nextLine();
            System.out.println(ANSI_YELLOW + "Введите номер телефона: " + ANSI_RESET);
            String phoneNumber = _sc.nextLine();
            System.out.println(ANSI_CLEAR_CONSOLE);
            String[] order = new String[] {fullName, email, phoneNumber, selectedWatchFirm, selectedWatchModel, countItem};
            System.out.println(ANSI_YELLOW + "Данные заказа:");
            for (String s : order) System.out.println(ANSI_GREEN + s + ANSI_RESET);
            _sc.nextLine();
            System.out.println(ANSI_CLEAR_CONSOLE);
            Orders.add(order);
        }
    }

    private static int ChooseWatchFirm(String[] watchCompanies) {
        List<String> watchCompaniesList = Arrays.stream(watchCompanies).toList();
        System.out.println("Список всех достпных часов");
        for (String i : watchCompaniesList) System.out.println((watchCompaniesList.indexOf(i) + 1) + ": " + i);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Выберите модель: " + ANSI_RESET);
        int a = _sc.nextInt() - 1;
        System.out.println(ANSI_CLEAR_CONSOLE);
        return a;
    }

    private static String ChooseModel(String[] watchModels) {
        for (int i = 1; i < watchModels.length; i++) System.out.println(i + ": " + watchModels[i]);
        System.out.println();
        System.out.println(ANSI_YELLOW + "Выберите модель: " + ANSI_RESET);
        int a = _sc.nextInt();
        System.out.println(ANSI_CLEAR_CONSOLE);
        return watchModels[a];
    }
}