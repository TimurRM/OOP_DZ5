package ru.geekbrains.oop.lesson5.presenters;

import ru.geekbrains.oop.lesson5.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    // Добавляем новый метод для изменения бронирования
    boolean changeReservation(int reservationId, Date newDate, int newTableNo, String newName);
}



