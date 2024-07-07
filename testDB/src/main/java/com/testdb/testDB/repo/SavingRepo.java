package com.testdb.testDB.repo;

import com.testdb.testDB.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SavingRepo extends JpaRepository<Saving,Long> {
}
