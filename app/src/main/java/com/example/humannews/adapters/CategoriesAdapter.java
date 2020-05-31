package com.example.humannews.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humannews.R;
import com.example.humannews.activities.MainActivity;
import com.example.humannews.models.CategoryItem;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    private List<CategoryItem> mDataSet;

    public CategoriesAdapter(List<CategoryItem> rssItems) {
        mDataSet = rssItems;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemCategoryView = inflater.inflate(R.layout.item_image_card, parent, false);
        return new CategoriesAdapter.CategoryViewHolder(itemCategoryView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryItem categoryItem = mDataSet.get(position);
        TextView textView = holder.titleTextView;
        ImageView imageView = holder.iconImageView;
        textView.setText(categoryItem.getTitle());
        imageView.setImageResource(categoryItem.getIconDrawable());
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("endpoint", categoryItem.getEndpoint());
            intent.putExtra("title", categoryItem.getTitle());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        ImageView iconImageView;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            iconImageView = itemView.findViewById(R.id.icon_img_view);
        }
    }
}
