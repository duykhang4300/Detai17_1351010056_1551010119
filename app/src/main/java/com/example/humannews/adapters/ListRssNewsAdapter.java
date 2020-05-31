package com.example.humannews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humannews.R;
import com.example.humannews.activities.WebViewActivity;
import com.example.humannews.utils.RssItem;

import java.util.List;

public class ListRssNewsAdapter extends RecyclerView.Adapter<ListRssNewsAdapter.MyViewHolder> {
    private List<RssItem> mDataSet;

    public ListRssNewsAdapter(List<RssItem> rssItems) {
        mDataSet = rssItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);
        return new MyViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RssItem rssItem = mDataSet.get(position);
        TextView textView = holder.nameTextView;
        textView.setText(rssItem.getTitle());
        TextView descriptionTextView = holder.descriptionTextView;
        String[] splitDescriptions = rssItem.getDescription().split("</a></br>");
        if (splitDescriptions.length >= 2) {
            descriptionTextView.setText(splitDescriptions[1]);
        }
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("url", rssItem.getLink());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descriptionTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.contact_name);
            descriptionTextView = itemView.findViewById(R.id.description_textview);

        }
    }
}
