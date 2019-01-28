package ua.org.crazy.microjson.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.org.crazy.microjson.domain.Document;
import ua.org.crazy.microjson.services.JsonToDocument;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
public class MainControllerTest {

    @MockBean
    private JsonToDocument jsonToDocument;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldDisplayDocuments() throws Exception {

        when(jsonToDocument.getSavedDocuments())
                .thenReturn(Collections.singletonList(buildDocument()));

        mockMvc.perform(
                get("/")
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("messages"))
                .andExpect(view().name("main"));
    }

    @Test
    public void shouldAppendAndDisplayDocuments() throws Exception {

        String testUrl = "testUrl";

        when(jsonToDocument.appendDocuments(eq(testUrl)))
                .thenReturn(Collections.singletonList(buildDocument()));

        mockMvc.perform(
                post("/")
                        .param("url", testUrl)
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("messages"))
                .andExpect(view().name("main"));
    }

    @Test
    public void shouldDisplayErrorIfDocumentsNotFound() throws Exception {

        String testUrl = "testUrl";

        when(jsonToDocument.appendDocuments(eq(testUrl)))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(
                post("/")
                        .param("url", testUrl)
        )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("messages", "error"))
                .andExpect(view().name("main"));
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