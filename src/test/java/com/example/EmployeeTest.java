package com.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("1", 10000);
    }


}