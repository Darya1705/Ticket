package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    int id;
    int price;
    String departureAirport;
    String arrivalAirport;
    int time;

    public boolean matches(String departureAirport, String arrivalAirport) {
        return this.getDepartureAirport().equalsIgnoreCase(departureAirport) && this.getArrivalAirport().equalsIgnoreCase(arrivalAirport);
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

}