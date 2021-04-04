package com.mindtree.BookApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.BookApplication.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.bookName=?1")
	Optional<Book> findByName(String name);
}
