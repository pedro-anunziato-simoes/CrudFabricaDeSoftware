package com.example.demo.repositories;

import com.example.demo.entities.EntityItensMagicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface RepositoryItensMagicos extends JpaRepository<EntityItensMagicos,Long> {
}
