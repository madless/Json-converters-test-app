package com.dmikhov.logansquaretest.models.logan;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by dmikhov on 26.01.2017.
 */
@JsonObject
public class Image {
    @JsonField
    int id;
    @JsonField
    String name;
    @JsonField
    String url;
    @JsonField
    Price price;

    public Image() {}

    public Image(int id, String name, String url, Price price) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "JImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }
}
