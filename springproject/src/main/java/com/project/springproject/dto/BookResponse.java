package com.project.springproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

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
