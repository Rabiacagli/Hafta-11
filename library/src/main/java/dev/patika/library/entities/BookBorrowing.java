package dev.patika.library.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookBorrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_borrowing_id")
    private int id;

    @Column(name = "borrower_name" ,nullable = false)
    private String name;

    @Column(name = "borrower_mail" ,nullable = false)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date" ,nullable = false)
    private LocalDate borrowingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "return_date")
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_bookBorrowing_id", referencedColumnName = "book_id")
    private Book book;
}
