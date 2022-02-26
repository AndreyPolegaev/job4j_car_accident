package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.RuleRepository;
import ru.job4j.accident.repository.TypeRepository;

import java.util.*;

@Service
@Transactional
public class AccidentDataService {

    private final AccidentRepository accidents;
    private final TypeRepository types;
    private final RuleRepository rules;

    public AccidentDataService(AccidentRepository accidents, TypeRepository types, RuleRepository rules) {
        this.accidents = accidents;
        this.types = types;
        this.rules = rules;
    }

    public List<Accident> getAllAccident() {
        return accidents.getAllAccidentsWithInnerObject();
    }

    /** получаем id статей и id Типа*/
    public void save(Accident accident, String[] ids, String type) {
        Set<Rule> rsl = new HashSet<>();
        AccidentType newType = types.findById(Integer.parseInt(type)).get();
        for (String temp : ids) {
            rsl.add(rules.findById(Integer.parseInt(temp)).get());
        }
        accident.setRules(rsl);
        accident.setType(newType);
        accidents.save(accident);
    }

    public Collection<AccidentType> getTypes() {
        List<AccidentType> rsl = new ArrayList<>();
        types.findAll().forEach(rsl::add);
        return rsl;
    }

    public Collection<Rule> getRules() {
        List<Rule> rsl = new ArrayList<>();
        rules.findAll().forEach(rsl::add);
        return rsl;
    }

    public void update(Accident accident) {
        accidents.update(accident.getName(), accident.getText(), accident.getAddress(), accident.getId());
    }

    public Accident getAccidentById(int id) {
        return accidents.findById(id).get();
    }

}
