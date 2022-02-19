package br.com.ialmeida.bookstore.repository;

import br.com.ialmeida.bookstore.model.BookDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class BookRepository {

    private final List<BookDTO> bookDTOList;

    public BookRepository() {
        bookDTOList = new ArrayList<>();
    }

    public void addBook(BookDTO bookDTO) {
        bookDTOList.add(bookDTO);
    }

    public BookDTO getBookDTOById(UUID id) {
        for (BookDTO book : bookDTOList) {
            if (Objects.equals(book.getId(), id)) {
                return book;
            }
        }

        return null;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public boolean updateBookDTO(UUID id, BookDTO bookDTO) {
        for (BookDTO book : bookDTOList) {
            if (Objects.equals(book.getId(), id)) {
                book.setAuthor(bookDTO.getAuthor());
                book.setDescription(bookDTO.getDescription());
                book.setGenre(bookDTO.getGenre());
                book.setName(bookDTO.getName());

                return true;
            }
        }

        return false;
    }

    public boolean deleteBookDTO(UUID id) {
        return bookDTOList.removeIf(book -> book.getId().equals(id));
    }

}
