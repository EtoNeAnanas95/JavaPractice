package org.example;
// импортим рабочие бибилы для практоса
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//объявление класса main
public class Main {
    //поле Scanner, чтоб не надо было создавать его тысячу раз в каждом методе
    public static Scanner sc = new Scanner(System.in);

    //стандартный метод main
    public static void main(String[] args) throws FileNotFoundException {
        //оюъявление экземпляра класса PrintWriter, чтобы неистого записывать данные в txt файлы
        PrintWriter pw = new PrintWriter("Students.txt");
        //лист модельного класса Student, чтоб удобного всё хранить в одном месте
        List<Student> students = new ArrayList<>();

        //цикл чтоб можно было добавить несколько школьникоу
        while (true) {
            //это штука должна чистить консоль, но я не уверен, потому что я так и не смог запустить эту штуку в нормальном поверешеле, несмотря на то, что мавен я поставил и даж проект там сбилдить смог
            System.out.println("\u000C");
            //проверка на отказ создавать нового студента
            if (!check()) {
                System.out.println("\u000C");
                System.out.println("Ладно, пока");
                break;
            }
            //если проверка пройдена, то мы создаём студента
            else {
                //сбрасываем буфер sc.nextLine(), я не уверен что он точно нужен, но я уже забыл когда я его писал, пусть будет
                sc.nextLine();
                //создаём нового студента с помощью отдельного метода
                Student student = CreateNewStudent();
                //добавляем его в список
                students.add(student);
            }
        }

        //после того, как мы создали нужное кол-во студентоу, можно из записать в файл
        //здесь всё просто, пробежимя по листу с студентами с помощью форича, и запишем каждое поле класса в txt файл
        for (Student student : students) {
            pw.println(student.name);
            pw.println(student.age);
            pw.println(student.GPS);
            //скидываем на новую строку в txt, для красоты
            pw.println("\n");
        }
        //закрываем соединение с принтврайтером
        pw.close();
    }

    //метод для создание студента
    public static Student CreateNewStudent() {
        //просим ввести имя
        System.out.println("Введите имя студента: ");
        String name = sc.nextLine();
        //сбрасываем буфер, чтоб не было ексепшона
        sc.nextLine();
        System.out.println("Введите возраст студента: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите средний балл студента: ");
        double GPS = sc.nextDouble();

        //возвращаем созданного студента
        return new Student(name, age, GPS);
    }

    //метод для того, чтоб пользователь мог решить хочет ли он добавлять ещё одного студента
    public static boolean check() {
        System.out.println("Добавить студента?");
        System.out.println("1. Да");
        System.out.println("2. Нет");

        int menu = sc.nextInt();

        //это какой-то хитрый ретюрн который мне поздасказала сама IDEA
        //ну в целом тут и так понятно что он делает, просто свитч засунули в ретюрн, чтоб строки сэкономить, и обрабаываем всего одмн сценарий где у нас пользователь согласен делать нового пользователя
        return switch (menu) {
            case 1 -> true;
            default -> false;
        };
    }
}