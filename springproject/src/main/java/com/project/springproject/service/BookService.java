package com.project.springproject.service;

import com.project.springproject.dto.BookRequest;
import com.project.springproject.dto.BookResponse;
import com.project.springproject.model.Book;
import com.project.springproject.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookResponse> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::mapToBookResponse).toList();
    }

    public void createBook(BookRequest bookRequest){
        Book book =Book.builder()
                .title(bookRequest.getTitle())
                .pengarang(bookRequest.getPengarang())
                .penerbit(bookRequest.getPenerbit())
                .tanggalTerbit(bookRequest.getTanggalTerbit())
                .tebalBuku(bookRequest.getTebalBuku())
                .statusBuku(bookRequest.getStatusBuku())
                .peminjam(bookRequest.getPeminjam())
                .tanggalPinjam(bookRequest.getTanggalPinjam())
                .tanggalKembali(bookRequest.getTanggalKembali()).build();
        bookRepository.save(book);
        log.info("Book Data {} is saved", book.getId());
    }


    public List<BookResponse> findAllByStatusBuku(String statusBuku){
        //return bookRepository.findAllByStatus(statusBuku);
        return bookRepository.findAllByStatusBuku(statusBuku).stream()
                .map(book -> BookResponse.builder()
                        .title(book.getTitle())
                        .penerbit(book.getPenerbit())
                        .pengarang(book.getPengarang())
                        .tanggalTerbit(book.getTanggalTerbit())
                        .tebalBuku(book.getTebalBuku())
                        .statusBuku(book.getStatusBuku())
                        .peminjam(book.getPeminjam())
                        .tanggalPinjam(book.getTanggalPinjam())
                        .tanggalKembali(book.getTanggalKembali()).build()).toList();
    }



    public BookResponse updateBook(Long id, BookRequest bookRequest){
        Optional<Book> updateBook = bookRepository.findById(id);
        Book result = new Book();
        if (updateBook.isPresent()){
            Book book = updateBook.get();
            book.setTitle(bookRequest.getTitle());
            book.setPengarang(bookRequest.getPengarang());
            book.setPenerbit(bookRequest.getPenerbit());
            book.setTanggalTerbit(bookRequest.getTanggalTerbit());
            book.setTebalBuku(bookRequest.getTebalBuku());
            book.setStatusBuku(bookRequest.getStatusBuku());
            book.setPeminjam(bookRequest.getPeminjam());
            book.setTanggalPinjam(bookRequest.getTanggalPinjam());
            book.setTanggalKembali(bookRequest.getTanggalKembali());
            result = bookRepository.save(book);

        }

        return BookResponse.builder().id(result.getId())
                .title(result.getTitle())
                .pengarang(result.getPengarang())
                .penerbit(result.getPenerbit())
                .tanggalTerbit(result.getTanggalTerbit())
                .tebalBuku(result.getTebalBuku())
                .statusBuku(result.getStatusBuku())
                .peminjam(result.getPeminjam())
                .tanggalPinjam(result.getTanggalPinjam())
                .tanggalKembali(result.getTanggalKembali()).build();
    }


    public BookResponse mapToBookResponse(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .pengarang(book.getPengarang())
                .penerbit(book.getPenerbit())
                .tanggalTerbit(book.getTanggalTerbit())
                .tebalBuku(book.getTebalBuku())
                .statusBuku(book.getStatusBuku())
                .peminjam(book.getPeminjam())
                .tanggalPinjam(book.getTanggalPinjam())
                .tanggalKembali(book.getTanggalKembali())
                .build();
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
