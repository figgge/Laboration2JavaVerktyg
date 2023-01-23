package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("1", 10000);
    }

    @Test
    void testGetIdShouldReturnSetUpValue() {
        assertEquals("1", employee.getId());
    }

    @Test
    void testSetIdShouldReturnGivenValue() {
        employee.setId("2");

        assertEquals("2", employee.getId());
    }

    @Test
    void testGetSalaryShouldReturnSetUpValue() {
        assertEquals(10000, employee.getSalary());
    }

    @Test
    void testSetSalaryShouldReturnGivenValue() {
        employee.setSalary(20000);

        assertEquals(20000, employee.getSalary());
    }

    @Test
    void testIsPaidShouldReturnFalse() {
        assertFalse(employee.isPaid());
    }

    @Test
    void testSetPaidShouldReturnGivenValue() {
        employee.setPaid(true);

        assertTrue(employee.isPaid());
    }

    @Test
    void testToString() {
        var expected = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(expected, employee.toString());
    }


}