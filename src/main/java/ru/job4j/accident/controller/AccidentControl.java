package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class AccidentControl {
    private final AccidentMem accidents;

    public AccidentControl(AccidentMem accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.save(accident);
        return "redirect:/index";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident) {
        accidents.update(accident);
        return "redirect:/index";
    }

    /** Обновление Accident*/
    @GetMapping("/update")
    public String update(@RequestParam(value = "id", required = false) String id, Model model) {
        model.addAttribute("updateAccident", accidents.getAccidentById(Integer.parseInt(id)));
        return "accident/edit";
    }
}
