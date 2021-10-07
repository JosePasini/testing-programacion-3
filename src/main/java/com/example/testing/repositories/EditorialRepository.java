package com.example.testing.repositories;

import com.example.testing.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends BaseRepository<Editorial, Long> {
}
