package dev.patika.library.dto.request.publisher;

import dev.patika.library.entities.Book;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherUpdateRequest {
    @Positive(message = "Lütfen pozitif bir sayı giriniz")
    private int id;

    @NotNull(message = "İsim bölümü boşv veya null olamaz")
    private String name;
    private String establishmentYear;
    private List<Book> bookList;
}
