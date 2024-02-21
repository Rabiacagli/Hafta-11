package dev.patika.library.dto.request.bookBorrowing;
import dev.patika.library.entities.Book;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingSaveRequest {
    @NotNull(message = "İsim bölümü boş veya null olamaz")
    private String name;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
    private Book book;
}
