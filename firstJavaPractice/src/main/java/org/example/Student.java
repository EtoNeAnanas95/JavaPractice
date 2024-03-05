package org.example;

// здесь я создал простенький класс, чтоб удобно хранить инорфмацию в одной переменной, а так же чтоб потренироваться с использование классов в JAVA

// объявили класс
public class Student {
    // поле класса name
    public String name;
    // поле класса age
    public int age;
    // поле класса gps
    public double GPS;

    //конструктор класса, чтоб удонбо засовывать в него данные
    public Student(String name, int age, double GPS) {
        this.name = name;
        this.age = age;
        this.GPS = GPS;
    }
}
