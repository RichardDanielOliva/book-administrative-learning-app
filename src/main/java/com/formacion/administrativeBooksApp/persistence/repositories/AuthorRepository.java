package com.formacion.administrativeBooksApp.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Optional<Author> findByNameAndLastname(String name, String lastname);
}
