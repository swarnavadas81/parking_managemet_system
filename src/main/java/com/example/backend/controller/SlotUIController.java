package com.example.backend.controller;

import com.example.backend.model.Slot;
import com.example.backend.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SlotUIController {

    @Autowired
    private SlotService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/slots")
    public String slots(Model model) {
        List<Slot> slots = service.getAll();
        model.addAttribute("slots", slots);
        return "slots";
    }

    @PostMapping("/slots/reserve")
    public String reserve(@RequestParam int id, @RequestParam String name) {
        Slot slot = service.getById(id);
        slot.setAvailable(false);
        slot.setName(name);
        service.save(slot);
        return "redirect:/slots";
    }

    @PostMapping("/slots/unreserve")
    public String unreserve(@RequestParam int id) {
        Slot slot = service.getById(id);
        slot.setAvailable(true);
        slot.setName(null);
        service.save(slot);
        return "redirect:/slots";
    }
}
