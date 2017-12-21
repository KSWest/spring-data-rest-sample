package com.springevenings.springdatarestsample.controller;

import com.springevenings.springdatarestsample.controller.exception.EmployeeNotFromThisCompanyException;
import com.springevenings.springdatarestsample.entity.Company;
import com.springevenings.springdatarestsample.entity.Employee;
import com.springevenings.springdatarestsample.repository.EmployeeRepository;
import com.springevenings.springdatarestsample.service.CompanyService;
import com.springevenings.springdatarestsample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/companies")
public class FireController {

    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    private CompanyService companyService;

    @PutMapping("/{companyid}/fire/{id}")
    public ResponseEntity fireEmployee(@PathVariable Long companyid, @PathVariable Long id) {
        Company company = companyService.read(companyid);
        Employee employee = employeeService.read(id);

        if (!company.equals(employee.getCompany())) {
            throw new EmployeeNotFromThisCompanyException(employee.getName() + " " + employee.getSurname()
                    + " is not from company " + company.getName());
        }

        employee.setCompany(null);
        employeeRepository.save(employee);

        return ResponseEntity.ok(employee.getName() + " " + employee.getSurname() + " has been fired from " +
                company.getName());
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
