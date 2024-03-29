package ru.geekbrains.oop.lesson5;

import ru.geekbrains.oop.lesson5.models.TableService;
import ru.geekbrains.oop.lesson5.presenters.BookingPresenter;
import ru.geekbrains.oop.lesson5.presenters.Model;
import ru.geekbrains.oop.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Model model = new TableService();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateTablesView();
        int reservationId = model.reservationTable(new Date(), 2, "Станислав");
        view.showReservationTableResult(reservationId);
        view.changeReservationTable(reservationId, new Date(), 4, "Сергей");
    }
}
