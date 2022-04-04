package com.example.ppot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistActivity extends AppCompatActivity {

    ArrayList<String> Hist=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView histlist;
    Button returnbt;
    TextView playerwins;
    TextView pcwins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist);
        histlist=(ListView) findViewById(R.id.histlist);
        returnbt=(Button) findViewById(R.id.returnbt);
        playerwins=(TextView) findViewById(R.id.textView2);
        pcwins=(TextView) findViewById(R.id.textView4);
        Hist=MatchTracker.getInstance().getHist();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Hist);
        histlist.setAdapter(adapter);
        pcwins.setText(MatchTracker.getInstance().getPcWins().toString());
        playerwins.setText(MatchTracker.getInstance().getPlayerWins().toString());
    }
    public void Return(View v){
        Intent intent = new Intent(HistActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void Reset(View v){
        Hist.clear();
        adapter.notifyDataSetChanged();
        MatchTracker.getInstance().reset();
        pcwins.setText(MatchTracker.getInstance().getPcWins().toString());
        playerwins.setText(MatchTracker.getInstance().getPlayerWins().toString());
    }
}
