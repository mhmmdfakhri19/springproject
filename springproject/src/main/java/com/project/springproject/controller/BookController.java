package com.project.springproject.controller;

import com.project.springproject.dto.BookRequest;
import com.project.springproject.dto.BookResponse;
import com.project.springproject.model.Book;
import com.project.springproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBook(@RequestBody BookRequest bookRequest){
        bookService.createBook(bookRequest);
        return "Data Buku tersimpan";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }


    @GetMapping("/{statusBuku}")
    public List<BookResponse> findAllByStatus(@PathVariable("statusBuku") String statusBuku){
        return bookService.findAllByStatusBuku(statusBuku);
    }



    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long id, @RequestBody BookRequest bookRequest){
        return bookService.updateBook(id, bookRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "Delete Book id: " +id.toString()+ "berhasil";
    }
}
