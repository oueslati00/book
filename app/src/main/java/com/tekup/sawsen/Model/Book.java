package com.tekup.sawsen.Model;

public class Book {

    private int imageId;
        private String author;
        private String title;


    public Book(String author, String title, int imageId) {
        this.imageId=imageId;
        this.author = author;
        this.title = title;
    }

    public String getTitle() {
            return title;
        }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
            return author;
        }

    public int getNumbersImageId() {
        return imageId;
    }
}

