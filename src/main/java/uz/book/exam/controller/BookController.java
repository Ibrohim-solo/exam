package uz.book.exam.controller;

import org.springframework.web.bind.annotation.*;
import uz.book.exam.dto.BookDto;
import uz.book.exam.dto.ResponseDto;
import uz.book.exam.service.impl.BookServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseDto<List<BookDto>> getAll() {
        return bookService.getAll();
    }
    @PostMapping
    public ResponseDto addBook(@RequestBody BookDto bookDto) {
        return bookService.addBook(bookDto);
    }
    @DeleteMapping
    public ResponseDto deleteBookById(@RequestParam Integer id) {
        return bookService.deleteBookById(id);
    }
    @PutMapping
    public ResponseDto updateBook(@RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }
}
