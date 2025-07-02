package com.example.backend.controller;

import com.example.backend.model.Slot;
import com.example.backend.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {

    @Autowired
    private SlotService service;

    // 🔹 Get all slots
    @GetMapping
    public List<Slot> getAllSlots() {
        return service.getAll();
    }

    // 🔹 Add a new slot
    @PostMapping
    public Slot createSlot(@RequestBody Slot slot) {
        return service.save(slot);
    }

    // 🔹 Update availability of a slot (reserve/release)
    @PutMapping("/{id}/availability")
    public Slot updateAvailability(@PathVariable int id, @RequestParam boolean available) {
        return service.setAvailability(id, available);
    }

    // 🔹 Delete a slot
    @DeleteMapping("/{id}")
    public void deleteSlot(@PathVariable int id) {
        service.delete(id);
    }
}
