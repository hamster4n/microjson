package ua.org.crazy.microjson.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.org.crazy.microjson.domain.Document;
import ua.org.crazy.microjson.repos.DocumentRepo;
import ua.org.crazy.microjson.services.JsonDownloader;
import ua.org.crazy.microjson.services.JsonToDocument;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JsonToDocumentTest {

    @Mock
    private JsonDownloader downloader;

    @Mock
    private DocumentRepo documentRepo;

    private JsonToDocument jsonToDocument;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        jsonToDocument = new JsonToDocument(downloader, documentRepo);
    }

    @Test
    public void shouldReturnDocuments() throws IOException {

        // given
        String testUrl = "TestUrl";

        Document document = buildDocument();

        when(documentRepo.findAll())
                .thenReturn(Collections.singletonList(document));
        //when
        List<Document> documents = jsonToDocument.appendDocuments(testUrl);

        //then
        assertThat(documents)
                .isNotNull()
                .isNotEmpty()
                .containsExactly(document);

        verify(downloader).run(eq(testUrl));
        verify(documentRepo).saveAll(anyIterable());
    }


    private Document buildDocument() {

        Document document = new Document();

        document.setCount_id(1L);
        document.setDateModified("2019-01-27");
        document.setDatePublished("2019-01-26");
        document.setDescription("TestDescription");
        document.setDocumentOf("TestDocumentOf");
        document.setDocumentType("TestDocumentType");
        document.setFormat("TestFormat");
        document.setHash("test_hash");
        document.setId("test_json_id");
        document.setTitle("title");
        document.setUrl("url");

        return document;
    }
}