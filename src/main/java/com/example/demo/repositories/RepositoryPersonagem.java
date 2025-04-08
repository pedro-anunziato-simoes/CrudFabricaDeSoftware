package com.example.demo.repositories;

import com.example.demo.entities.EntityPersonagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPersonagem extends JpaRepository<EntityPersonagem,Long> {
}
