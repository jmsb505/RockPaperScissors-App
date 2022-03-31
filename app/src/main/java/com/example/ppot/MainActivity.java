package com.example.ppot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton piedrabt;
    private ImageView imageView;
    private ImageButton papelbt;
    private ImageButton tijerabt;
    private Button histbt;
    private Button roundbt;
    private Random rand=new Random();
    private MatchTracker matchTracker=MatchTracker.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlace de componentes
        piedrabt=(ImageButton) findViewById(R.id.piedrabt);
        imageView=(ImageView) findViewById(R.id.imageView);
        papelbt=(ImageButton) findViewById(R.id.papelbt);
        tijerabt=(ImageButton) findViewById(R.id.tijerabt);
        histbt=(Button) findViewById(R.id.histbt);
        roundbt=(Button) findViewById(R.id.roundbt);
        piedrabt.setOnClickListener(ev1);
        papelbt.setOnClickListener(ev2);
        tijerabt.setOnClickListener(ev3);
        roundbt.setOnClickListener(ev4);
    }
    private final View.OnClickListener ev1=new View.OnClickListener(){//Evento usando piedra

        @Override
        public void onClick(View view) {
        Integer num=rand.nextInt(2);//Del 0 al 2, 0 piedra 1 papel 2 tijera
        if(num==0)//piedra
        {
            //Empate,muestra imagen de roca de PC
            matchTracker.setRound(0,num);
            imageView.setImageResource(R.drawable.rock);

        }
        else if(num==1)//papel
        {
            //Perdida, mostrar imagen, gana PC
            matchTracker.setRound(0,num);
            imageView.setImageResource(R.drawable.paper);
        }
        else//tijera
        {
            //Gana, mostrar imagen
            matchTracker.setRound(0,num);
            imageView.setImageResource(R.drawable.scissors);
        }
        piedrabt.setEnabled(false);
        tijerabt.setEnabled(false);
        papelbt.setEnabled(false);

        }
    };
    private final View.OnClickListener ev2=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Integer num=rand.nextInt(2);//Del 0 al 2, 0 piedra 1 papel 2 tijera
            if(num==0)
            {//Jugador Gana, mostrar en imagen
                matchTracker.setRound(1,num);
                imageView.setImageResource(R.drawable.rock);

            }
            else if(num==1) {
                matchTracker.setRound(1,num);//Empate
                imageView.setImageResource(R.drawable.paper);
            }
            else
            {
                //Pierde mostrar en imagen
                matchTracker.setRound(1,num);
                imageView.setImageResource(R.drawable.scissors);
            }
            piedrabt.setEnabled(false);
            tijerabt.setEnabled(false);
            papelbt.setEnabled(false);

        }
    };
    private final View.OnClickListener ev3=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            Integer num=rand.nextInt(2);//Del 0 al 2, 0 piedra 1 papel 2 tijera
            if(num==0)
            {
                //Perdida
                matchTracker.setRound(2,num);
                imageView.setImageResource(R.drawable.rock);
            }
            else if(num==1)
            {
                //Gana
                matchTracker.setRound(2,num);
                imageView.setImageResource(R.drawable.paper);
            }
            else
            {
                //Empate
                matchTracker.setRound(2,num);
                imageView.setImageResource(R.drawable.scissors);
            }
            piedrabt.setEnabled(false);
            tijerabt.setEnabled(false);
            papelbt.setEnabled(false);


        }
    };
    private final View.OnClickListener ev4=new View.OnClickListener()
    {

        @Override
        public void onClick(View view) {
            piedrabt.setEnabled(true);
            tijerabt.setEnabled(true);
            papelbt.setEnabled(true);
        }
    };
}