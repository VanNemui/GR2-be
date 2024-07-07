package com.testdb.testDB.repo;

import com.testdb.testDB.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface UserRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);

}
