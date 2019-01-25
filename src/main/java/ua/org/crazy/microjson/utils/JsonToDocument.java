package ua.org.crazy.microjson.utils;

import com.google.gson.Gson;
import ua.org.crazy.microjson.domain.Data;
import ua.org.crazy.microjson.domain.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JsonToDocument {
    public static ArrayList<Document> getListDocuments(String json) throws IOException {
        Gson gson = new Gson();
        JsonDownloader downloader = new JsonDownloader();
        Data arr;
        String jsonString = downloader.run(json);
        try {
            arr = gson.fromJson(jsonString, Data.class);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return arr.list;
    }
}
