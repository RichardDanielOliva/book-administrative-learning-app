package com.formacion.administrativeBooksApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
