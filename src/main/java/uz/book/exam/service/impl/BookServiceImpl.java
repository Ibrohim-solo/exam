package uz.book.exam.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.book.exam.dto.BookDto;
import uz.book.exam.dto.ResponseDto;
import uz.book.exam.entity.Book;
import uz.book.exam.repository.BookRepository;
import uz.book.exam.service.BookService;
import uz.book.exam.service.mapper.BookMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    @Override
    public ResponseDto<List<BookDto>> getAll() {
        try {
            List<Book> book = repository.findAll();
            return ResponseDto.<List<BookDto>>builder()
                    .code(0)
                    .message("OK")
                    .succes(true)
                    .data(book.stream()
                            .map(BookMapper::toDto)
                            .toList())
                    .build();
        } catch (Exception i){
            return ResponseDto.<List<BookDto>>builder().code(-1).message("not").succes(false).build();
        }
    }

    @Override
    public ResponseDto addBook(BookDto bookDto) {
        try {
            Book book = BookMapper.toEntity(bookDto);
            repository.save(book);
            return ResponseDto.builder()
                    .code(0)
                    .message("OK")
                    .succes(true)
                    .build();
        }catch (Exception i){
            return ResponseDto.builder()
                    .code(0)
                    .message("OK")
                    .succes(true)
                    .build();
        }
    }

    @Override
    public ResponseDto deleteBookById(Integer id) {
        try {
            repository.deleteById(id);
            return ResponseDto.builder()
                    .code(0)
                    .succes(true)
                    .message("OK")
                    .build();
        } catch (Exception i){
            return ResponseDto.builder()
                    .code(-1)
                    .message("OK")
                    .succes(false)
                    .build();
        }
    }

    @Override
    public ResponseDto updateBook(BookDto bookDto) {
        try {
            List<Book> books = repository.findAll();
            for (int i = 0; i < books.size(); i++) {
                if(books.get(i).getId().equals(bookDto.getId()) && bookDto.getId() != null) books.get(i).setId(bookDto.getId());
                if(books.get(i).getName().equals(bookDto.getName()) && bookDto.getName() != null) books.get(i).setName(bookDto.getName());
                if(books.get(i).getPrice().equals(bookDto.getPrice()) && bookDto.getPrice() != null) books.get(i).setPrice(bookDto.getPrice());
                if(books.get(i).getPublishedAt().equals(bookDto.getPublishedAt()) && bookDto.getPublishedAt() != null) books.get(i).setPublishedAt(bookDto.getPublishedAt());
                if(books.get(i).getPublishedBy().equals(bookDto.getPublishedBy()) && bookDto.getPublishedBy() != null) books.get(i).setPublishedBy(bookDto.getPublishedBy());
                if(books.get(i).getAuthorName().equals(bookDto.getAuthorName()) && bookDto.getAuthorName() != null) books.get(i).setAuthorName(bookDto.getAuthorName());
                if(books.get(i).getPages().equals(bookDto.getPages()) && bookDto.getPages() != null) books.get(i).setPages(bookDto.getPages());
                if(books.get(i).getGenre().equals(bookDto.getGenre()) && bookDto.getGenre() != null) books.get(i).setGenre(bookDto.getGenre());
            }
            return ResponseDto.builder()
                    .code(0)
                    .succes(true)
                    .message("OK")
                    .build();


        } catch (Exception i){
            return ResponseDto.builder()
                    .code(-1)
                    .succes(false)
                    .message("NOT")
                    .build();
        }
    }
}
