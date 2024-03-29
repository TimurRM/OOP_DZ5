package ru.geekbrains.oop.lesson5.models;

import ru.geekbrains.oop.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableService implements Model {

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }
    @Override
    public boolean changeReservation(int reservationId, Date newDate, int newTableNo, String newName) {
        Reservation existingReservation = null;
        Table oldTable = null;

        // Найти существующее бронирование и соответствующий столик
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationId) {
                    existingReservation = reservation;
                    oldTable = table;
                    break;
                }
            }
            if (existingReservation != null) break; // Выходим из цикла, если бронирование найдено
        }

        if (existingReservation == null || oldTable == null || oldTable.getNo() == newTableNo) {
            // Бронирование не найдено или новый номер столика совпадает со старым
            return false;
        }

        // Поиск нового столика для бронирования
        Table newTable = tables.stream()
                .filter(t -> t.getNo() == newTableNo)
                .findFirst()
                .orElse(null);

        if (newTable == null) {
            // Новый столик для бронирования не найден
            return false;
        }

        // Удаление старого бронирования и создание нового
        oldTable.getReservations().remove(existingReservation);
        Reservation newReservation = new Reservation(newTable, newDate, newName);
        newTable.getReservations().add(newReservation);

        return true; // Успешное изменение бронирования
    }

}
