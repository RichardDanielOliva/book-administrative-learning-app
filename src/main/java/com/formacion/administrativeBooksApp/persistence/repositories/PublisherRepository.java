package com.formacion.administrativeBooksApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
