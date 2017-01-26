package com.dmikhov.logansquaretest.models.moshi;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class MImage {
    int id;
    String name;
    String url;
    MPrice price;

    public MImage() {}

    public MImage(int id, String name, String url, MPrice price) {
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

    public MPrice getPrice() {
        return price;
    }

    public void setPrice(MPrice price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                '}';
    }
}
