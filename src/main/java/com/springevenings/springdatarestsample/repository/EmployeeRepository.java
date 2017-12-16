package com.springevenings.springdatarestsample.repository;

import com.springevenings.springdatarestsample.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

}
