package br.com.ialmeida.bookstore.services;

import br.com.ialmeida.bookstore.model.BookDTO;
import br.com.ialmeida.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(BookDTO bookDTO) {
        bookRepository.addBook(bookDTO);
    }

    public BookDTO getBookDTOById(UUID id) {
        return bookRepository.getBookDTOById(id);
    }

    public List<BookDTO> getBookDTOList() {
        return bookRepository.getBookDTOList();
    }

    public void updateBookDTO(UUID id, BookDTO bookDTO) {
        bookRepository.updateBookDTO(id, bookDTO);
    }

    public void deleteBookDTO(UUID id) {
        bookRepository.deleteBookDTO(id);
    }

}
