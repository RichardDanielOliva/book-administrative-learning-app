package com.formacion.administrativeBooksApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer> {

}
