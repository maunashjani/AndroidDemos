package com.example.demo20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView;

        // Initializing list view with the custom adapter
        ArrayList<Item> wordList = new ArrayList<Item>();

        wordlistadapter adapter = new wordlistadapter(R.layout.wordlist_row, wordList);
        recyclerView = (RecyclerView) findViewById(R.id.wordListRCV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // Populating list items
        for(int i=1; i<=100; i++) {
            wordList.add(new Item("Record " + i));
        }

    }
}
