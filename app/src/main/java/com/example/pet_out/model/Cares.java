package com.example.pet_out.model;

public class Cares {

    private String name,info;
    private int photo;

    public Cares(String name, String info, int photo) {
        this.name = name;
        this.info = info;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
