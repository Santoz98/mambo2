package com.example.dell.mambo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.mambo.R;
import com.example.dell.mambo.helper.MainActivity;
import com.example.dell.mambo.youtube.ReadRss;

public class BotFragment extends Fragment {

    public BotFragment() {
        // Required empty public constructor
    }

    public static BotFragment newInstance(String param1, String param2) {
        BotFragment fragment = new BotFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bot, container, false);
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewutube);
        //Call Read rss asyntask to fetch rss
        ReadRss readRss = new ReadRss(getContext(), recyclerView);
        readRss.execute();
        return view;
    }
}
