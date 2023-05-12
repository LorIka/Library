package com.example.lidraryTest.repository;

import com.example.lidraryTest.entity.Authors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRep extends CrudRepository<Authors, Long> {
        public List<Authors> findByFirstNameLike(String fName);

        public List<Authors> findByLastNameLike(String lName);

        @Query("SELECT c.id FROM Authors c")
        public List<Long> findById();

}
