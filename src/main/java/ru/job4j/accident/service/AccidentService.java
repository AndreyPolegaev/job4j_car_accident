package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.*;

/**
 * логика работы
 * Сервис зависит от Repository
 */

@Service
public class AccidentService {

    private final AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public List<Accident> getAllAccident() {
        return new ArrayList<>(accidentMem.getAllAccident());
    }

    public void save(Accident accident, String[] ids) {
        Map<Integer, Rule> rules = accidentMem.getRules();
        Set<Rule> rsl = new HashSet<>();
        for (String temp : ids) {
            if (rules.containsKey(Integer.parseInt(temp))) {
                rsl.add(rules.get(Integer.parseInt(temp)));
            }
            accident.setRules(rsl);
            accidentMem.save(accident);
        }
    }

    public Collection<AccidentType> getTypes() {
        return accidentMem.getTypes();
    }

    public Collection<Rule> getRules() {
        return accidentMem.getRules().values();
    }

    public void update(Accident accident) {
        accidentMem.update(accident);
    }

    public Accident getAccidentById(int id) {
        return accidentMem.getAccidentById(id);
    }
}
