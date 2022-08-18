package uz.book.exam.service;

import org.springframework.stereotype.Service;
import uz.book.exam.dto.BookDto;
import uz.book.exam.dto.ResponseDto;

import java.util.List;

public interface BookService {
    ResponseDto<List<BookDto>> getAll();
    ResponseDto addBook(BookDto bookDto);
    ResponseDto deleteBookById(Integer id);
    ResponseDto updateBook(BookDto bookDto);
}
