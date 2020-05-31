package com.example.humannews.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.humannews.R;
import com.example.humannews.adapters.ListRssNewsAdapter;
import com.example.humannews.networkings.Api;
import com.example.humannews.utils.RssFeedProvider;
import com.example.humannews.utils.RssItem;

import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private List<RssItem> listRssNews;
    private RecyclerView listRssNewsRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListRssNewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listRssNews = new ArrayList<>();
        listRssNewsRecyclerView = (RecyclerView) findViewById(R.id.list_rss_news_rv);
        listRssNewsRecyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listRssNewsRecyclerView.setLayoutManager(layoutManager);
        adapter = new ListRssNewsAdapter(listRssNews);
        listRssNewsRecyclerView.setAdapter(adapter);
        String url = Api.VNEXPRESS_DOMAIN + "/tin-moi-nhat.rss";
        fetchNews(url);
    }

    void fetchNews(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String myResponse = response.body().string();
                try {
                    List<RssItem> rssItems
                            = RssFeedProvider.parse(myResponse);
                    listRssNews.addAll(rssItems);
                    MainActivity.this.runOnUiThread(() -> {
                        adapter.notifyDataSetChanged();
                    });
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

