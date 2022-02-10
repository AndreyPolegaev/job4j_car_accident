package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * хранилище инцидентов
 */

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    private AtomicInteger ai = new AtomicInteger(1);

    private int count;

    public AccidentMem() {
        accidents.put(ai.getAndIncrement(), new Accident(++count, "Light accident", "desc1", "Street1"));
        accidents.put(ai.getAndIncrement(), new Accident(++count, "Middle accident", "desc2", "Street2"));
        accidents.put(ai.getAndIncrement(), new Accident(++count, "Serious accident", "desc3", "Street3"));
    }

    public Collection<Accident> getAllAccident() {
        return accidents.values();
    }

    public Accident getAccidentById(int id) {
        return accidents.get(id);
    }

    public void save(Accident accident) {

        accidents.put(ai.getAndIncrement(), accident);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

}

