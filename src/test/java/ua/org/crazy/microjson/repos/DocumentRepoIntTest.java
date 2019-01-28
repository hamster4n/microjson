package ua.org.crazy.microjson.repos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import ua.org.crazy.microjson.domain.Document;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DocumentRepoIntTest {
    @Autowired
    private DocumentRepo documentRepo;


    @Test
    @Sql("classpath:/datasets/oneDocuments.sql")
    public void shouldReturnDocuments(){

        Iterable<Document> documents = documentRepo.findAll();

        assertThat(documents)
                .isNotNull()
                .hasSize(1);
    }
}
