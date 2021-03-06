package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentDataService;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AccidentControl {

    private final AccidentDataService service;

    public AccidentControl(AccidentDataService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getTypes());
        model.addAttribute("rules", service.getRules());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        String type = req.getParameterValues("type.id")[0];
        service.save(accident, ids, type);
        return "redirect:/index";
    }

    @PostMapping("/updateAccident")
    public String update(@ModelAttribute Accident accident) {
        service.update(accident);
        return "redirect:/index";
    }

    /** Обновление Accident*/
    @GetMapping("/update")
    public String update(@RequestParam(value = "id", required = false) String id, Model model) {
        model.addAttribute("updateAccident", service.getAccidentById(Integer.parseInt(id)));
        return "accident/edit";
    }
}
