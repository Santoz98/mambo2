package com.example.dell.mambo.youtube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.dell.mambo.R;

public class YoutubeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //Call Read rss asyntask to fetch rss
        ReadRss readRss = new ReadRss(this, recyclerView);
        readRss.execute();
    }

}
