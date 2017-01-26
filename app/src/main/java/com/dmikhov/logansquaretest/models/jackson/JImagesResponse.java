package com.dmikhov.logansquaretest.models.jackson;

import java.util.List;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class JImagesResponse {
    List<JImage> images;

    public JImagesResponse() {}

    public JImagesResponse(List<JImage> images) {
        this.images = images;
    }

    public List<JImage> getImages() {
        return images;
    }

    public void setImages(List<JImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "JImagesResponse{" +
                "images=" + images +
                '}';
    }
}
