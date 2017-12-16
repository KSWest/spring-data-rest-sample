package com.springevenings.springdatarestsample.controller;

import com.springevenings.springdatarestsample.entity.Company;
import com.springevenings.springdatarestsample.entity.Employee;
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
public class HireController {

    private EmployeeService employeeService;
    private CompanyService companyService;

    @PutMapping("/{companyid}/hire/{id}")
    public ResponseEntity hireEmployee(@PathVariable Long companyid, @PathVariable Long id) {
        Company company = companyService.read(companyid);
        Employee employee = employeeService.read(id);

        employee.setCompany(company);
        employeeService.update(employee);

        return ResponseEntity.ok(employee.getName() + " " + employee.getSurname() + " has been hired to " +
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
}
