package com.dmikhov.logansquaretest.models.gson;

import java.util.List;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class GImagesResponse {
    List<GImage> images;

    public GImagesResponse() {}

    public GImagesResponse(List<GImage> images) {
        this.images = images;
    }

    public List<GImage> getImages() {
        return images;
    }

    public void setImages(List<GImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "JImagesResponse{" +
                "images=" + images +
                '}';
    }
}
