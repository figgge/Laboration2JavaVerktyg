package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class EmployeesTest {
    EmployeeRepository employeeRepository;
    BankService bankService;
    Employee employee1, employee2, employee3;
    Employees employees;

    @BeforeEach
    void setUp() {
        employeeRepository = new EmployeeRepositoryImpl();
        bankService = Mockito.mock(BankService.class);
        employees = new Employees(employeeRepository, bankService);

        employee1 = new Employee("1", 1000);
        employee2 = new Employee("2", 2000);
        employee3 = new Employee("3", 3000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
    }

    @Test
    void payEmployees() {
    }
}