package com.springevenings.springdatarestsample.repository;

import com.springevenings.springdatarestsample.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
