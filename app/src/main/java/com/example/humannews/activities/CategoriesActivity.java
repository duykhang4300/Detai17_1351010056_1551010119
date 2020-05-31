package com.example.humannews.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humannews.R;
import com.example.humannews.adapters.CategoriesAdapter;
import com.example.humannews.utils.constants.MockupDataProvider;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView categoriesRecyclerView;
    private GridLayoutManager layoutManager;
    private CategoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        categoriesRecyclerView = findViewById(R.id.categories_rv);
        categoriesRecyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        categoriesRecyclerView.setLayoutManager(layoutManager);
        adapter = new CategoriesAdapter(MockupDataProvider.createVNExpressCategories());
        categoriesRecyclerView.setAdapter(adapter);
    }
}
