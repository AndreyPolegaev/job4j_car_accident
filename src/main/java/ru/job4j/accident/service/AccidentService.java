package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.ArrayList;
import java.util.List;

/** логика работы
 *  Сервис зависит от Repository
 */

@Service
public class AccidentService {

    private AccidentMem accidentMem;

    public AccidentService(AccidentMem accidentMem) {
        this.accidentMem = accidentMem;
    }

    public List<Accident> getAllAccident() {
        List<Accident> accidents = new ArrayList<>(accidentMem.getAllAccident());
        return accidents;
    }

}
