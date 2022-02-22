package ru.netology;

import java.util.Arrays;

public class TicketManager {
    private final TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] searchBy(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket item : repository.findAll()) {
            if (item.matches(departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
            Arrays.sort(result);
        }
        return result;
    }

}



