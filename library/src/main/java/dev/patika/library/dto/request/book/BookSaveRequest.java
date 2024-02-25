package dev.patika.library.dto.request.book;

import dev.patika.library.entities.Author;
import dev.patika.library.entities.BookBorrowing;
import dev.patika.library.entities.Category;
import dev.patika.library.entities.Publisher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {

    @NotNull(message = "Kştap adı boş veya null olamaz")
    private String name;
    private int publicationYear;
    private int stock;
    private int authorId;
    private int publisherId;

}


