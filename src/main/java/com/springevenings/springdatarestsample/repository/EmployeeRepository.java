package com.springevenings.springdatarestsample.repository;

import com.springevenings.springdatarestsample.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    @Override
    @PreAuthorize("hasRole({'ROLE_ADMIN', 'ROLE_MANAGER'})")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole({'ROLE_ADMIN', 'ROLE_MANAGER'})")
    void delete(Employee employee);
}