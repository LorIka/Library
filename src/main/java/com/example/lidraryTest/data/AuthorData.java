package com.example.lidraryTest.data;

import com.example.lidraryTest.entity.Authors;
import com.example.lidraryTest.repository.AuthorRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthorData implements ApplicationRunner {
        private AuthorRep authorRep;
        @Autowired
        public AuthorData(AuthorRep authorRepository) {
            this.authorRep = authorRepository;
        }
        @Override
        public void run(ApplicationArguments args) throws Exception {
            long count=authorRep.count();
            Authors a1 = new Authors();
            if (count==0) {
                a1.setFirstName("jogyft");
                a1.setLastName("dfsfdgsdgs");
                authorRep.save(a1);
                System.out.println(a1.getFirstName().toString()+" "+a1.getLastName().toString());
            }
        }
}
