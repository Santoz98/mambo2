package com.example.dell.mambo;

/**
 * Created by Dell on 2/21/2018.
 */

public class Chapter {
    int imageId;
    String aboutText;

    public Chapter(String aboutText,int imageId) {
        this.aboutText = aboutText;
        this.imageId = imageId;
    }
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAboutText() {
        return aboutText;
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }
}