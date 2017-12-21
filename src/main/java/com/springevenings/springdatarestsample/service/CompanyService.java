package com.springevenings.springdatarestsample.service;

import com.springevenings.springdatarestsample.entity.Company;
import com.springevenings.springdatarestsample.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public Company read(Long id) {
        Company company = companyRepository.findOne(id);

        if (company == null) {
            throw new ResourceNotFoundException();  // should be from org.springframework.data.rest.webmvc package
        }

        return company;
    }

    public Iterable<Company> readAll() {
        Iterable<Company> allCompanies = companyRepository.findAll();

        if (allCompanies.spliterator().getExactSizeIfKnown() == 0) {
            throw new ResourceNotFoundException();  // should be from org.springframework.data.rest.webmvc package
        }

        return allCompanies;
    }

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
