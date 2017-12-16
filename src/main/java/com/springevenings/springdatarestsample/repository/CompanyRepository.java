package com.springevenings.springdatarestsample.repository;

import com.springevenings.springdatarestsample.entity.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

// means, that path '/users' will not exist
//@RepositoryRestResource(exported = false)

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

}
