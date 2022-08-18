package uz.book.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Integer id;
    private String name;
    private Double price;
    private Date publishedAt;
    private String publishedBy;
    private String authorName;
    private Integer pages;
    private String genre;
}
