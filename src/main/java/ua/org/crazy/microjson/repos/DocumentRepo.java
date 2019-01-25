package ua.org.crazy.microjson.repos;

import org.springframework.data.repository.CrudRepository;
import ua.org.crazy.microjson.domain.Document;

public interface DocumentRepo extends CrudRepository<Document, Long> {
}
