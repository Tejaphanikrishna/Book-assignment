package com.mindtree.BookApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.BookApplication.entity.Writer;
@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer> {

}
