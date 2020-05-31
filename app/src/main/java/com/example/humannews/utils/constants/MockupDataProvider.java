package com.example.humannews.utils.constants;

import com.example.humannews.enums.ECategory;
import com.example.humannews.models.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MockupDataProvider {
    static public List<CategoryItem> createVNExpressCategories() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(ECategory.WORLD, "Thế giới", "/the-gioi.rss"));
        categoryItemList.add(new CategoryItem(ECategory.DAILY_NEWS, "Thời sự", "/thoi-su.rss"));
        return categoryItemList;
    }
}
