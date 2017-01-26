package com.dmikhov.logansquaretest.models.logan;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 * Created by dmikhov on 26.01.2017.
 */
@JsonObject
public class ImagesResponse {
    @JsonField
    List<Image> images;

    public ImagesResponse() {}

    public ImagesResponse(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "JImagesResponse{" +
                "images=" + images +
                '}';
    }
}
