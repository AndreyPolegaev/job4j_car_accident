package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;
import java.util.*;

/**
 * логика работы
 * Сервис зависит от Repository
 */

@Service
public class AccidentService {

    private final AccidentHibernate accidents;

    public AccidentService(AccidentHibernate accidents) {
        this.accidents = accidents;
    }

    public List<Accident> getAllAccident() {
        return new ArrayList<>(accidents.getAllAccident());
    }

    /** получаем id статей и id Типа*/
    public void save(Accident accident, String[] ids, String type) {
        Set<Rule> rsl = new HashSet<>();
        AccidentType newType = accidents.getTypeById(Integer.parseInt(type));
        if (ids != null && ids.length != 0) {
            for (String temp : ids) {
                rsl.add(accidents.getRulesById(Integer.parseInt(temp)));
            }
        } else {
            rsl = Collections.emptySet();
        }
        accident.setRules(rsl);
        accident.setType(newType);
        accidents.save(accident);
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
