package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class EmployeeRepositoryImplTest {

    @Test
    void findAllShouldReturnAllEmployees() {
        var employeeRepository = new EmployeeRepositoryImpl();
        var employee1 = new Employee("1", 1000);
        var employee2 = new Employee("2", 2000);
        var employee3 = new Employee("3", 3000);
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

        var employees = employeeRepository.findAll();

        assertThat(employees).containsExactlyInAnyOrder(employee1, employee2, employee3);
    }






}
