package ua.org.crazy.microjson.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("data")
    public List<Document> documents;

    @Override
    public String toString() {
        return "" + documents;
    }
}
