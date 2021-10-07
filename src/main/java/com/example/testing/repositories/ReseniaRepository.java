package com.example.testing.repositories;

import com.example.testing.entities.Resenia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReseniaRepository extends BaseRepository<Resenia, Long> {
}
