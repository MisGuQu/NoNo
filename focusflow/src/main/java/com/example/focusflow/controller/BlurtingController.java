package com.example.focusflow.controller;

import com.example.focusflow.model.Blurting;
import com.example.focusflow.service.BlurtingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blurting")
public class BlurtingController {

    @Autowired
    private BlurtingService blurtingService;

    @GetMapping
    public String getAllBlurting(Model model) {
        List<Blurting> blurtings = blurtingService.findAll();
        model.addAttribute("blurtings", blurtings);
        return "blurting";
    }

    @PostMapping("/create")
    public String createBlurting(@RequestParam String content,
                                 @RequestParam Long sessionId) {
        blurtingService.createBlurting(content, sessionId);
        return "redirect:/blurting";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlurting(@PathVariable Long id) {
        blurtingService.deleteById(id);
        return "redirect:/blurting";
    }
}
