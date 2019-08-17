package com.formacion.administrativeBooksApp.persistence.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.administrativeBooksApp.persistence.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByPublicationDateAfter(Date fechaBusqueda);
	List<Book> findByPublicationDateBefore(Date fechaBusqueda);
	List<Book> findByPublicationDate(Date fechaBusqueda);
}
