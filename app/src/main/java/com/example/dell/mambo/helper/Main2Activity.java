package com.example.dell.mambo.helper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.dell.mambo.R;
import com.example.dell.mambo.youtube.ReadRss;

public class Main2Activity extends AppCompatActivity {
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
