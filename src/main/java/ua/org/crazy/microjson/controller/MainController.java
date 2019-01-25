package ua.org.crazy.microjson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.org.crazy.microjson.domain.Document;
import ua.org.crazy.microjson.repos.DocumentRepo;
import ua.org.crazy.microjson.utils.JsonDownloader;
import ua.org.crazy.microjson.utils.JsonToDocument;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    private DocumentRepo documentRepo;

    private JsonDownloader jsonDownloader = new JsonDownloader();

    @GetMapping()
    public String main(Model model) {
        Iterable<Document> messages = documentRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String url, Model model) throws IOException {
        System.out.println();
        if (jsonDownloader.isValidUrl(url)) {
            ArrayList<Document> listDocument = JsonToDocument.getListDocuments(url);
            if (!listDocument.isEmpty()) {
                documentRepo.saveAll(listDocument);
                model.addAttribute("saved", "Data successfully saved!");
            } else {
                model.addAttribute("error", "Url or Json not valid!");
            }
        } else {
            model.addAttribute("error", "You input not URL");
        }
        Iterable<Document> messages = documentRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }
}
