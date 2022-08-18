package uz.book.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.book.exam.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
