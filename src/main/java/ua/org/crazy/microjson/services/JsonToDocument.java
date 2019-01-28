package ua.org.crazy.microjson.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.crazy.microjson.domain.Document;
import ua.org.crazy.microjson.repos.DocumentRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class JsonToDocument {

    private final JsonDownloader jsonDownloader;
    private final DocumentRepo documentRepo;

    @Autowired
    public JsonToDocument(JsonDownloader jsonDownloader, DocumentRepo documentRepo) {
        this.jsonDownloader = jsonDownloader;
        this.documentRepo = documentRepo;
    }

    public boolean isValidUrl(String url){
        return jsonDownloader.isValidUrl(url);
    }

    public List<Document> appendDocuments(String url){
        List<Document> documents = fetchDocuments(url);
        saveDocuments(documents);
        return getSavedDocuments();
    }

    public List<Document> fetchDocuments(String url){
        try {
            return jsonDownloader.run(url);
        } catch (Exception e){
            return Collections.emptyList();
        }
    }

    public List<Document> getSavedDocuments() {
        List<Document> documents = new ArrayList<>();
        documentRepo.findAll().forEach(documents::add);
        return documents;
    }

    private void saveDocuments(List<Document> documents) {
        documentRepo.saveAll(documents);
    }
}
