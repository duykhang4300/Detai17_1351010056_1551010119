package com.example.humannews.utils.constants;

import com.example.humannews.R;
import com.example.humannews.enums.ECategory;
import com.example.humannews.models.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MockupDataProvider {
    static public List<CategoryItem> createVNExpressCategories() {
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(ECategory.WORLD, "Thế giới", "/the-gioi.rss", R.drawable.ic_earth));
        categoryItemList.add(new CategoryItem(ECategory.DAILY_NEWS, "Thời sự", "/thoi-su.rss", R.drawable.ic_newspaper));
        categoryItemList.add(new CategoryItem(ECategory.BUSINESS, "Kinh doanh", "/kinh-doanh.rss", R.drawable.ic_growing));
        categoryItemList.add(new CategoryItem(ECategory.STARTUP, "Startup", "/startup.rss", R.drawable.ic_rocket));
        categoryItemList.add(new CategoryItem(ECategory.ENTERTAINMENT, "Entertainment", "/giai-tri.rss", R.drawable.ic_lights));
        return categoryItemList;
    }
}
