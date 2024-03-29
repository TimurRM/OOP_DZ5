package ru.geekbrains.oop.lesson5.models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000; // Общий счетчик для всех бронирований
    private int id; // Уникальный ID для каждого бронирования

    private Table table;
    private Date date;
    private String name;

    public Reservation(Table table, Date date, String name) {
        this.id = ++counter; // Увеличиваем счетчик перед присвоением, чтобы каждая бронь имела уникальный ID
        this.table = table;
        this.date = date;
        this.name = name;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", table=" + table.getNo() + // Предполагая, что у класса Table есть метод getNo()
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }


}
