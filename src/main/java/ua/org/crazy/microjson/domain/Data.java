package ua.org.crazy.microjson.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("data")
    public ArrayList<Document> list;

    @Override
    public String toString() {
        return "" + list;
    }
}
