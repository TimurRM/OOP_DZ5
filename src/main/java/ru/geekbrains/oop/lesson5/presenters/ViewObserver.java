package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onChangeReservation(int reservationId, Date newDate, int newTableNo, String newName);
}


