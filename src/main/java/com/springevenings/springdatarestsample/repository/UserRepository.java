package com.springevenings.springdatarestsample.repository;

import com.springevenings.springdatarestsample.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// means, that path '/users' will not exist
@RepositoryRestResource(exported = false)
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(String username);
}
