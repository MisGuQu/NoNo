package com.example.focusflow.controller;

import com.example.focusflow.model.ThreeTwoOne;
import com.example.focusflow.service.ThreeTwoOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/three-two-one")
public class ThreeTwoOneController {

    @Autowired
    private ThreeTwoOneService threeTwoOneService;

    @GetMapping
    public String getAllThreeTwoOne(Model model) {
        List<ThreeTwoOne> entries = threeTwoOneService.findAll();
        model.addAttribute("threeTwoOnes", entries);
        return "three-two-one";
    }

    @PostMapping("/create")
    public String create(@RequestParam String threeThings,
                         @RequestParam String twoInteresting,
                         @RequestParam String oneQuestion,
                         @RequestParam Long sessionId) {
        threeTwoOneService.create(threeThings, twoInteresting, oneQuestion, sessionId);
        return "redirect:/three-two-one";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        threeTwoOneService.deleteById(id);
        return "redirect:/three-two-one";
    }
}
