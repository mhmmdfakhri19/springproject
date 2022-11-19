package com.project.springproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "books")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String pengarang;
    private String penerbit;
    private Date tanggalTerbit;
    private Integer tebalBuku;
    private String statusBuku;
    private String peminjam;
    private Date tanggalPinjam;
    private Date tanggalKembali;
}
