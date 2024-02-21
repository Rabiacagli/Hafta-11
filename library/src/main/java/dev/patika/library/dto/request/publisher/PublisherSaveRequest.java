package dev.patika.library.dto.request.publisher;

import dev.patika.library.entities.Book;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {
    private int id;
    @NotNull(message = "isim bölümü boş veya null olamaz")
    private String name;
    private String establishmentYear;
    private List<Book> bookList;
}
