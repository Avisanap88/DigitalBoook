package com.digitalbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalbook.entities.Reader;


public interface ReaderServiceRepository extends JpaRepository<Reader, Integer> {
  
}
