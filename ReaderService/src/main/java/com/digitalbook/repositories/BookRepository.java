package com.digitalbook.repositories;
import com.digitalbook.entities.*;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT b FROM Book b where (b.category=?1 or b.user.username=?2 or b.price=?3 or b.publisher=?4) and b.activeFlag=1")
    public List<Book> getBookDetails(String category, String author, Long price, String publisher);



}
