package com.testdb.testDB.repo;

import com.testdb.testDB.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface CategoryRepo extends JpaRepository<Category,Long> {

}
