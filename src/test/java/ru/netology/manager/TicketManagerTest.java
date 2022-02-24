package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private final TicketRepository repository = new TicketRepository();
    TicketManager managers = new TicketManager(repository);
    private final Ticket first = new Ticket(1, 1000, "DME", "LED", 90);
    private final Ticket second = new Ticket(2, 2000, "DME", "LED", 95);
    private final Ticket third = new Ticket(3, 3000, "DME", "LED", 100);
    private final Ticket fourth = new Ticket(4, 4000, "VKO", "LED", 110);
    private final Ticket fifth = new Ticket(5, 500, "VKO", "LED", 200);
    private final Ticket sixth = new Ticket(6, 6000, "DME", "VOZ", 60);

    @Test
    public void add() {
        managers.add(first);
        managers.add(third);
        managers.add(sixth);

        Ticket[] expected = {first, third, sixth};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void add2() {
        managers.add(second);

        Ticket[] expected = {second};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchBy() {
        managers.add(first);
        managers.add(second);
        managers.add(third);

        Ticket[] actual = managers.searchBy("DME", "LED");
        Ticket[] expected = new Ticket[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy2() {
        managers.add(sixth);

        Ticket[] actual = managers.searchBy("DME", "VOZ");
        Ticket[] expected = new Ticket[]{sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy3() {
        managers.add(fifth);
        managers.add(fourth);

        Ticket[] actual = managers.searchBy("VKO", "LED");
        Ticket[] expected = new Ticket[]{fifth, fourth};
        assertArrayEquals(expected, actual);
    }

}