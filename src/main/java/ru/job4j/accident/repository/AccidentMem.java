package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * хранилище инцидентов
 */

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final Map<Integer, AccidentType> types = new HashMap<>();
    private final Map<Integer, Rule> rules = new HashMap<>();
    private final AtomicInteger ai = new AtomicInteger(1);

    public AccidentMem() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
        accidents.put(ai.getAndIncrement(), new Accident(ai.get() - 1, "Авария", "desc1", "Ленинский пр-т д.1", types.get(0), rules.values()));
        accidents.put(ai.getAndIncrement(), new Accident(ai.get() - 1, "Нарушение ПДД", "desc2", "ул. Зорге д.5", types.get(0), rules.values()));
        accidents.put(ai.getAndIncrement(), new Accident(ai.get() - 1, "Уехал с места ДТП", "desc3", "ул. Вавилова д.3", types.get(0), rules.values()));
    }

    public Collection<Accident> getAllAccident() {
        return accidents.values();
    }

    public Accident getAccidentById(int id) {
        return accidents.get(id);
    }

    public void save(Accident accident) {
        accident.setId(ai.getAndIncrement());
        accidents.put(ai.get() - 1, accident);
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
    }

    public Map<Integer, Rule> getRules() {
        return rules;
    }

}

