package com.example.focusflow.controller;

import com.example.focusflow.model.FeynmanNote;
import com.example.focusflow.service.FeynmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/feynman")
public class FeynmanController {

    @Autowired
    private FeynmanService feynmanService;

    @GetMapping
    public String getAll(Model model) {
        List<FeynmanNote> notes = feynmanService.findAll();
        model.addAttribute("feynmans", notes);
        return "feynman";
    }

    @PostMapping("/create")
    public String create(@RequestParam String topic,
                         @RequestParam String explanation,
                         @RequestParam Long sessionId) {
        feynmanService.create(topic, explanation, sessionId);
        return "redirect:/feynman";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        feynmanService.deleteById(id);
        return "redirect:/feynman";
    }
}
