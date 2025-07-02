package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // ✅ Default constructor (MUST HAVE)
    public Employee() {}

    // ✅ Full constructor (optional)
    public Employee(String name) {
        this.name = name;
    }

    // ✅ Getter for ID
    public int getId() {
        return id;
    }

    // ✅ Setter for ID
    public void setId(int id) {
        this.id = id;
    }

    // ✅ Getter for name
    public String getName() {
        return name;
    }

    // ✅ Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
