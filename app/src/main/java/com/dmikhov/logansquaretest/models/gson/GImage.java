package com.dmikhov.logansquaretest.models.gson;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class GImage {
    int id;
    String name;
    String url;
    GPrice price;

    public GImage() {}

    public GImage(int id, String name, String url, GPrice price) {
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

    public GPrice getPrice() {
        return price;
    }

    public void setPrice(GPrice price) {
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
