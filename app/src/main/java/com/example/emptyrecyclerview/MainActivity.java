package com.example.emptyrecyclerview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CustomRecylerViewAdaptor mAdapter;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEmpty = findViewById(R.id.btnEmpty);

        Button btnload = findViewById(R.id.btnload);
        EmptyRecyclerView recyclerView = findViewById(R.id.recyclerView);
        //recyclerView.setEmptyViewGravity(RelativeLayout.CENTER_HORIZONTAL);
        //recyclerView.setEmptyViewParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
//        EmptyRecyclerView.EmptyTextView emptyTextView = recyclerView.withEmptyView(this);
//        emptyTextView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
//        emptyTextView.setText("No Records found Click Load Data Button to show the data");
//        emptyTextView.setGravity(Gravity.CENTER);
//        emptyTextView.built();
//        recyclerView.setEmptyViewStr("No Records found Click Load Data Button to show the data");


        mAdapter = new CustomRecylerViewAdaptor(arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        btnEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.clear();
                mAdapter.notifyDataSetChanged();
            }
        });
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();
            }
        });
        prepareData();
    }

    private void prepareData() {
        for (int i = 0; i <= 20; i++) {
            arrayList.add("Sample Data " + i);
        }
        mAdapter.notifyDataSetChanged();
    }
}
