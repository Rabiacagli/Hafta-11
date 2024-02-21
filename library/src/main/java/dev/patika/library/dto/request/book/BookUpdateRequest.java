package dev.patika.library.dto.request.book;

import dev.patika.library.entities.Author;
import dev.patika.library.entities.BookBorrowing;
import dev.patika.library.entities.Category;
import dev.patika.library.entities.Publisher;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateRequest {

    @Positive(message = "ID değeri pozitif sayı olmak zorunda")
    private int id;
    @NotNull(message = "Kategori adı boş veya null olamaz")
    private String name;
    private int publicationYear;
    private int stock;





}
