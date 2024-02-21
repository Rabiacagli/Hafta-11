package dev.patika.library.dto.response.publisher;

import dev.patika.library.entities.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {
    private int id;
    private String name;
    private String establishmentYear;
    private List<Book> bookList;
}
