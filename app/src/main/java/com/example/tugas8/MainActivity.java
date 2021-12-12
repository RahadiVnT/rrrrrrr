package com.example.tugas8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,mentertainment,mtopalbum,mtrendingmusic,mconcert,mquiz,mscandal;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String api_key = "d084aa285ae24879b93afaa17a1ccdff";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome=findViewById(R.id.home);
        mentertainment=findViewById(R.id.entertainment);
        mtopalbum=findViewById(R.id.topalbum);
        mtrendingmusic=findViewById(R.id.trending);
        mconcert=findViewById(R.id.concert);
        mquiz=findViewById(R.id.quiz);
        mscandal=findViewById(R.id.scandal);
        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||
                        tab.getPosition()==2||tab.getPosition()==3 ||
                        tab.getPosition()==4||tab.getPosition()==5 ||
                        tab.getPosition()==6)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}