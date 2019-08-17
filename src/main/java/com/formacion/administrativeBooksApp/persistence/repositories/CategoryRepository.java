package com.formacion.administrativeBooksApp.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
