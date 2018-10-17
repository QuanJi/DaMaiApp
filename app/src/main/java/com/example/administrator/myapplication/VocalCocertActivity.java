package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import Adapter.ScrollPageAdapter;
import Entity.ScrollPage;

public class VocalCocertActivity extends AppCompatActivity {


    private List<ScrollPage> scrollPageList=new ArrayList<>();
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.sscrollbarrecycleview);
        initScrollpage();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.scrollpage);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        ScrollPageAdapter adapter=new ScrollPageAdapter(scrollPageList);
        recyclerView.setAdapter(adapter);

    }

    public void initScrollpage(){
        for(int i=0;i<=10;i++) {
            ScrollPage one = new ScrollPage(R.drawable.concert, "asdss");
            scrollPageList.add(one);
        }}

}
