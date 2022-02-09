package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.HashMap;

/** хранилище инцидентов */

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(0, new Accident("Light accident", "desc1", "Street1"));
        accidents.put(1, new Accident("Middle accident", "desc2", "Street2"));
        accidents.put(2, new Accident("Serious accident", "desc3", "Street3"));
    }

    public Collection<Accident> getAllAccident() {
        return accidents.values();
    }
}
