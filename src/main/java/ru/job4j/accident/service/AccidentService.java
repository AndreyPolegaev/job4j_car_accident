package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import ru.job4j.accident.repository.AccidentMem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * логика работы
 * Сервис зависит от Repository
 */

@Service
public class AccidentService {

    private final AccidentJdbcTemplate accidents;

    public AccidentService(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }

    public List<Accident> getAllAccident() {
        return new ArrayList<>(accidents.getAllAccident());
    }

    public void save(Accident accident, String[] ids) {
        Map<Integer, Rule> rules = new HashMap<>();
        for (Rule temp : accidents.getRules()) {
            rules.put(temp.getId(), temp);
        }
        Set<Rule> rsl = new HashSet<>();
        for (String temp : ids) {
            if (rules.containsKey(Integer.parseInt(temp))) {
                rsl.add(rules.get(Integer.parseInt(temp)));
            }
            accident.setRules(rsl);
            accidents.save(accident);
        }
    }

    public Collection<AccidentType> getTypes() {
        return accidents.getTypes();
    }

    public Collection<Rule> getRules() {
        return accidents.getRules();
    }

    public void update(Accident accident) {
        accidents.update(accident);
    }

    public Accident getAccidentById(int id) {
        return accidents.getAccidentById(id);
    }
}
