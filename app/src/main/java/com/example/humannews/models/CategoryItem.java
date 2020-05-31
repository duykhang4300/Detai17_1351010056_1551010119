package com.example.humannews.models;

import com.example.humannews.enums.ECategory;

public class CategoryItem {
    private ECategory eCategory;
    private String title;
    private String endpoint;

    public CategoryItem(ECategory eCategory, String title, String endpoint) {
        this.eCategory = eCategory;
        this.title = title;
        this.endpoint = endpoint;
    }

    public ECategory geteCategory() {
        return eCategory;
    }

    public void seteCategory(ECategory eCategory) {
        this.eCategory = eCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
