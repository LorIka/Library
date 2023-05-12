package com.example.lidraryTest.repository;

import com.example.lidraryTest.entity.Authors;
import com.example.lidraryTest.entity.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface BookRep extends CrudRepository<Books, Long> {
    public List<Books> findByBookNameLike(String bName);

}
