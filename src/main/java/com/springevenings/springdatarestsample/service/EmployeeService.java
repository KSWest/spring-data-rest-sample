package com.springevenings.springdatarestsample.service;

import com.springevenings.springdatarestsample.entity.Employee;
import com.springevenings.springdatarestsample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Employee read(Long id) {
        Employee employee = employeeRepository.findOne(id);

        if (employee == null) {
            throw new ResourceNotFoundException();  // should be from org.springframework.data.rest.webmvc package
        }

        return employee;
    }

    public Iterable<Employee> readAll() {
        Iterable<Employee> allEmployees = employeeRepository.findAll();

        if (allEmployees.spliterator().getExactSizeIfKnown() == 0) {
            throw new ResourceNotFoundException();  // should be from org.springframework.data.rest.webmvc package
        }

        return allEmployees;
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
