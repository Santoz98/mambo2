package com.example.dell.mambo.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.mambo.Chapter;
import com.example.dell.mambo.R;
import com.example.dell.mambo.helper.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class JourneyFragment extends Fragment {
    public ImageView thumbnail;


    public JourneyFragment() {
        // Required empty public constructor
    }

    public static JourneyFragment newInstance(String param1, String param2) {
        JourneyFragment fragment = new JourneyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        // get the button view
        thumbnail = (ImageView) getView().findViewById(R.id.thumbnail);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_journey, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        //RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        List<Chapter> movieList = new ArrayList<>();
        JourneyA mAdapter = new JourneyA(getActivity(), movieList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new MainActivity.GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);


        int[] covers = new int[]{
                R.drawable.a1,
                R.drawable.a2,
                R.drawable.a3,
                R.drawable.a4,
                R.drawable.a5,
                R.drawable.a6,
                R.drawable.a7,
                R.drawable.a8,
                R.drawable.a9,
                R.drawable.a10,
                R.drawable.a11,
                R.drawable.a12};

        Chapter a = new Chapter("Chapter1", covers[0]);
        movieList.add(a);

         a = new Chapter("Chapter2", covers[1]);
        movieList.add(a);

        a = new Chapter("Chapter3 ", covers[2]);
        movieList.add(a);

        a = new Chapter("Chapter4", covers[3]);
        movieList.add(a);
        a = new Chapter("Chapter5", covers[4]);
        movieList.add(a);
        a = new Chapter("Chapter6", covers[5]);
        movieList.add(a);
        a = new Chapter("Chapter7", covers[6]);
        movieList.add(a);
        a = new Chapter("Chapter8", covers[7]);
        movieList.add(a);
        a = new Chapter("Chapter9", covers[8]);
        movieList.add(a);
        a = new Chapter("Chapter10", covers[9]);
        movieList.add(a);
        a = new Chapter("Chapter11", covers[10]);
        movieList.add(a);
        a = new Chapter("Chapter12", covers[11]);
        movieList.add(a);



        return view;
    }


    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}


class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spanCount;
    private int spacing;
    private boolean includeEdge;

    public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}

 class JourneyA extends RecyclerView.Adapter<JourneyA.MyViewHolder> {

    private Context mContext;
    private List<Chapter> chapterList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            thumbnail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String a= String.valueOf(view.getId());
                    Toast.makeText(mContext.getApplicationContext(), a,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    public JourneyA(Context mContext, List<Chapter> chapterList) {
        this.mContext = mContext;
        this.chapterList = chapterList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journey_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Chapter chapter = chapterList.get(position);
        holder.title.setText(chapter.getAboutText());


        Glide.with(mContext).load(chapter.getImageId()).into(holder.thumbnail);


    }
    @Override
    public int getItemCount() {
        return chapterList.size();
    }

}

