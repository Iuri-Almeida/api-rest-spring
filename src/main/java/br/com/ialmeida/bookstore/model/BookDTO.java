package br.com.ialmeida.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BookDTO {

    private UUID id;
    private String name;
    private String description;
    private String author;
    private String genre;

    public BookDTO() {
        id = UUID.randomUUID();
    }
}
