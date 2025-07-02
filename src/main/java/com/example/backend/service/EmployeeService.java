package com.example.backend.service;

import com.example.backend.model.Employee;
import com.example.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee save(Employee e) {
        return repo.save(e);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public Employee getById(int id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
}
