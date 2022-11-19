package com.project.springproject.repository;

import com.project.springproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //List<Book> findAllByStatusBuku(List<String> statusBuku);

    List<Book> findAllByStatusBuku(String statusBuku);
}
