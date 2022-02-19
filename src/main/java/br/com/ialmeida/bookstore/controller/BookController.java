package br.com.ialmeida.bookstore.controller;

import br.com.ialmeida.bookstore.model.BookDTO;
import br.com.ialmeida.bookstore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/bookstore")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    private ResponseEntity<List<BookDTO>> getBooks() {
        List<BookDTO> response = bookService.getBookDTOList();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<BookDTO>> getBooks2() {
        return getBooks();
    }

    @GetMapping("/{id}")
    private ResponseEntity<BookDTO> getBook(@PathVariable("id") UUID id) {
        BookDTO response = bookService.getBookDTOById(id);

        if (response == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);

        return new ResponseEntity<>("Book added successfully!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<String> updateBook(@PathVariable("id") UUID id, @RequestBody BookDTO bookDTO) {
        BookDTO response = bookService.getBookDTOById(id);

        if (response == null) {
            return new ResponseEntity<>("Book not found!", HttpStatus.NOT_FOUND);
        }

        bookService.updateBookDTO(id, bookDTO);

        return new ResponseEntity<>("Book updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteBook(@PathVariable("id") UUID id) {
        BookDTO response = bookService.getBookDTOById(id);

        if (response == null) {
            return new ResponseEntity<>("Book not found!", HttpStatus.NOT_FOUND);
        }

        bookService.deleteBookDTO(id);

        return new ResponseEntity<>("Book deleted successfully!", HttpStatus.OK);
    }

}
