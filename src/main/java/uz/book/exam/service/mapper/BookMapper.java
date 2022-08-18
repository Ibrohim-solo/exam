package uz.book.exam.service.mapper;

import uz.book.exam.dto.BookDto;
import uz.book.exam.entity.Book;

public class BookMapper {
    public static Book toEntity(BookDto bookDto){
        return Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .price(bookDto.getPrice())
                .publishedAt(bookDto.getPublishedAt())
                .publishedBy(bookDto.getPublishedBy())
                .authorName(bookDto.getAuthorName())
                .pages(bookDto.getPages())
                .genre(bookDto.getGenre())
                .build();
    }
    public static BookDto toDto(Book book){
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .publishedAt(book.getPublishedAt())
                .publishedBy(book.getPublishedBy())
                .authorName(book.getAuthorName())
                .pages(book.getPages())
                .genre(book.getGenre())
                .build();
    }
}
