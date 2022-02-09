package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl1 {

    @GetMapping("/")
    public String index(Model model) {
        List<String> list = new ArrayList<>(List.of("One", "Two", "Three"));
        model.addAttribute("strings", list);
        return "index";
    }
}
