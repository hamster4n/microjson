package ua.org.crazy.microjson.services;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import ua.org.crazy.microjson.domain.Data;
import ua.org.crazy.microjson.domain.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class JsonDownloader {

    private OkHttpClient client;

    private final Gson gson;

    public JsonDownloader() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    public List<Document> run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String json = response.body().string();
            Data readDate = gson.fromJson(json, Data.class);
            return readDate.documents;
        }
    }

    public  boolean isValidUrl(String url) {
        try {
            URL u = new URL(url);
            u.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
}
