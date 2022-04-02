package com.example.ppot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistActivity extends AppCompatActivity {

    ArrayList<String> Hist=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView histlist;
    Button returnbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist);
        histlist=(ListView) findViewById(R.id.histlist);
        returnbt=(Button) findViewById(R.id.returnbt);
        Hist=MatchTracker.getInstance().getHist();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Hist);
        histlist.setAdapter(adapter);
    }
    public void Return(View v){
        Intent intent = new Intent(HistActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
