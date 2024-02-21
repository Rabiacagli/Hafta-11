package dev.patika.library.dto.request.bookBorrowing;

import dev.patika.library.entities.Book;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    @NotNull(message = "isim bölümü boş veya nulll olamaz")
    private String name;

    @Positive(message = "Lütfen pozitif bir sayıs giriniz")
    private int id;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private Book book;
}
