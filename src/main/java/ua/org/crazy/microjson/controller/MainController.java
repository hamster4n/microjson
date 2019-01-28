package ua.org.crazy.microjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.org.crazy.microjson.domain.Document;
import ua.org.crazy.microjson.repos.DocumentRepo;
import ua.org.crazy.microjson.services.JsonDownloader;
import ua.org.crazy.microjson.services.JsonToDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private JsonToDocument jsonToDocument;

    @Autowired
    public MainController(JsonToDocument jsonToDocument) {
        this.jsonToDocument = jsonToDocument;
    }

    @GetMapping()
    public String main(Model model) {
        List<Document> messages = jsonToDocument.getSavedDocuments();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String url, Model model){
        if (!jsonToDocument.isValidUrl(url)){
            List<Document> listDocument = jsonToDocument.getSavedDocuments();
            model.addAttribute("error", "You input not URL");
            model.addAttribute("messages", listDocument);
            return "main";
        }

        List<Document> listDocument = jsonToDocument.fetchDocuments(url);

        if (!listDocument.isEmpty()) {
            listDocument = jsonToDocument.appendDocuments(url);
            model.addAttribute("saved", "Data successfully saved!");
        } else {
            listDocument = jsonToDocument.getSavedDocuments();
            model.addAttribute("error", "Url or Json not valid!");
        }

        model.addAttribute("messages", listDocument);
        return "main";
    }
}
