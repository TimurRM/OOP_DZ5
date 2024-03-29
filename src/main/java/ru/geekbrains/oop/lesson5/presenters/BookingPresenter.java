package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private  View view;

    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    private void updateReservationTableView(int reservationNo){
        view.showReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        }
        catch (Exception e){
            updateReservationTableView(-1);
        }

    }
    @Override
    public void onChangeReservation(int reservationId, Date newDate, int newTableNo, String newName) {
        try {
            boolean success = model.changeReservation(reservationId, newDate, newTableNo, newName);
            if (success) {
                view.showReservationTableResult(reservationId); // Можно использовать ID для подтверждения успешного изменения
            } else {
                view.showReservationTableResult(-1); // Или использовать отрицательное значение для ошибки
            }
        } catch (Exception e) {
            view.showReservationTableResult(-1);
        }
    }

}
