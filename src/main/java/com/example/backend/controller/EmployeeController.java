package com.example.backend.controller;

import com.example.backend.model.Employee;
import com.example.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee e) {
        return service.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee e) {
        Employee existing = service.getById(id);
        existing.setName(e.getName());
        return service.save(existing);
    }
}
