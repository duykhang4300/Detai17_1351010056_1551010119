package com.example.humannews.models;

import com.example.humannews.enums.ECategory;

public class CategoryItem {
    private ECategory eCategory;
    private String title;
    private String endpoint;
    private int iconDrawable;

    public CategoryItem(ECategory eCategory, String title, String endpoint, int iconDrawable) {
        this.eCategory = eCategory;
        this.title = title;
        this.endpoint = endpoint;
        this.iconDrawable = iconDrawable;
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

    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }
}
