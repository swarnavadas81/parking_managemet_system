package com.example.backend.service;

import com.example.backend.model.Slot;
import com.example.backend.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    @Autowired
    private SlotRepository repo;

    // Get all slots
    public List<Slot> getAll() {
        return repo.findAll();
    }

    // Save a slot
    public Slot save(Slot slot) {
        return repo.save(slot);
    }

    // Get slot by ID
    public Slot getById(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }

    // Delete slot by ID
    public void delete(int id) {
        repo.deleteById(id);
    }

    // Mark slot availability
    public Slot setAvailability(int id, boolean available) {
        Slot slot = getById(id);
        slot.setAvailable(available);
        if (available) {
            slot.setName(null); // remove name if unreserved
        }
        return repo.save(slot);
    }

    // 🔹 Reserve slot (sets available to false, assigns name)
    public void reserveSlot(int id, String name) {
        Slot slot = getById(id);
        if (!slot.isAvailable()) {
            throw new RuntimeException("Slot is already reserved");
        }
        slot.setAvailable(false);
        slot.setName(name);
        repo.save(slot);
    }

    // 🔹 Unreserve slot (sets available to true, clears name)
    public void unreserveSlot(int id) {
        Slot slot = getById(id);
        if (slot.isAvailable()) {
            throw new RuntimeException("Slot is already available");
        }
        slot.setAvailable(true);
        slot.setName(null);
        repo.save(slot);
    }
}
