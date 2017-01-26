package com.dmikhov.logansquaretest.models.moshi;

import java.util.List;

/**
 * Created by dmikhov on 26.01.2017.
 */
public class MImagesResponse {
    List<MImage> images;

    public MImagesResponse() {}

    public MImagesResponse(List<MImage> images) {
        this.images = images;
    }

    public List<MImage> getImages() {
        return images;
    }

    public void setImages(List<MImage> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "MImagesResponse{" +
                "images=" + images +
                '}';
    }
}
