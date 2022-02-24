package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private final TicketRepository repository = new TicketRepository();
    private final Ticket first = new Ticket(1, 1000, "DME", "LED", 90);
    private final Ticket second = new Ticket(2, 2000, "DME", "LED", 95);
    private final Ticket third = new Ticket(3, 3000, "DME", "LED", 100);
    private final Ticket fourth = new Ticket(4, 4000, "VKO", "LED", 110);
    private final Ticket fifth = new Ticket(5, 5000, "LED", "DME", 200);
    private final Ticket sixth = new Ticket(6, 6000, "DME", "VOZ", 60);


    @Test
    void findAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Ticket[] expected = {first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        repository.removeById(6);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {first, second, third, fourth, fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById2() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        repository.removeById(1);
        repository.removeById(2);
        repository.removeById(3);
        repository.removeById(4);
        repository.removeById(5);
        //repository.removeById(6);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {first, second, third, fourth, fifth, sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2() {
        repository.save(sixth);

        Ticket[] actual = repository.findAll();
        Ticket[] expected = {sixth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void should17Id() {
        assertThrows(NotFoundException.class, () -> repository.removeById(17));
    }
}








