package com.example.dell.mambo.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dell.mambo.Chapter;
import com.example.dell.mambo.R;
import com.example.dell.mambo.fragments.HomeFragment;
import com.example.dell.mambo.fragments.MoreFragment;
import com.example.dell.mambo.fragments.ActivitiesFragment;
import com.example.dell.mambo.fragments.BotFragment;
import com.example.dell.mambo.fragments.JourneyFragment;
import com.example.dell.mambo.fragments.RSS;
import com.example.dell.mambo.youtube.ReadRss;
import com.example.dell.mambo.youtube.YoutubeActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Context mContext;
    private JourneyFragment adapter;
    private List<Chapter> chapterList;
    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        chapterList = new ArrayList<>();
        /*adapter = new JourneyFragment(this, chapterList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareChapters();
*/
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            Activity activity;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.navigation_journey:
                    toolbar.setTitle("Journey");
                    fragment =new JourneyFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_activities:
                    toolbar.setTitle("Stories");
                    fragment = new ActivitiesFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_bot:
                    toolbar.setTitle("Youtube");
                    fragment = new BotFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_more:
                    toolbar.setTitle("Chatbot");
                    fragment = new MoreFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadActivity(Activity activity) {
    //RSS rss= new RSS();
    startActivity(new Intent(this,RSS.class));
    }

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void journey(View v){
        Toast.makeText(mContext.getApplicationContext(),"f",Toast.LENGTH_LONG).show();
    }



    private void prepareChapters() {
        int[] covers = new int[]{
                R.drawable.chap1,
                R.drawable.chap2,
                R.drawable.chap3,
                R.drawable.chap4,
                R.drawable.chap5,
                R.drawable.chap6,
                R.drawable.chap7,
                R.drawable.chap8,
                R.drawable.chap9,
                R.drawable.chap10,
                R.drawable.chap11,
                R.drawable.chap12};

        Chapter a = new Chapter("True Romance", covers[0]);
        chapterList.add(a);

        a = new Chapter("Xscpae", covers[1]);
        chapterList.add(a);

        a = new Chapter("nnnn", covers[2]);
        chapterList.add(a);

        a = new Chapter("mmmm", covers[3]);
        chapterList.add(a);

        a = new Chapter("Xeeeete", covers[4]);
        chapterList.add(a);

        a = new Chapter("kkkk", covers[5]);
        chapterList.add(a);

        a = new Chapter("iiiiae", covers[6]);
        chapterList.add(a);

        a = new Chapter("aaaaaaaa", covers[7]);
        chapterList.add(a);

        a = new Chapter("bbbbb", covers[8]);
        chapterList.add(a);

        a = new Chapter("yyyyyy", covers[9]);
        chapterList.add(a);

        a = new Chapter("tfwry", covers[10]);
        chapterList.add(a);

        a = new Chapter("u4ij9orfmej", covers[11]);
        chapterList.add(a);


 //       adapter.notifyDataSetChanged();
    }


    public static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

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
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}

