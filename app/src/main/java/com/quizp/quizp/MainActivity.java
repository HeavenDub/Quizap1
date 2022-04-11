package com.quizp.quizp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed(){
    };

    public static ArrayList<ModelClass> Listofq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Listofq = new ArrayList<>();
        Listofq.add(new ModelClass("What is Hitler's favorite flower?","Edelweiss","Wulfeniana","Primula","Banadiana","Edelweiss"));
        Listofq.add(new ModelClass("Which country started socialism at first?","Cuba","USSR","Porto Rico","China","USSR"));
        Listofq.add(new ModelClass("What was the cause of Japan retreat from the WW2?","Atomic Bomb","Hydrogen Bomb","Nuclear Bomb","Pearl Harbor Bomb","Nuclear Bomb"));
        Listofq.add(new ModelClass("Who started the WW1?","Serbia","Bosnia","Germany","Autrich","Serbia"));
        Listofq.add(new ModelClass("What brand was known for containing drugs?","Coca Cola","Pepsi","Mountain Dew","Dr Pepper","Coca Cola"));
        Listofq.add(new ModelClass("Which Philosopher dissed Karl Marx?","Carl Jung","Dostoevsky","Max Stirner","Ludwig Wittgenstein","Max Stirner"));
        Listofq.add(new ModelClass("What Country had the apartheid?","South Africa","Russia","USA","Germany","South Africa"));
        Listofq.add(new ModelClass("Which city in USA was famous for Aliens?","Gulfport","Chicago","Roswell","Minneapolis","Roswell"));
        Listofq.add(new ModelClass("What part of the map is the last populated area (South)?","Ushuaia","Macao","Cape Town","Longyearbyen","Ushuaia"));
        Listofq.add(new ModelClass("Which Philosopher had an Oedipus Complex?","Freud","Dostoevsky","Nietzsche","J.P.Sartre","Freud"));


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);

            }




        },1500);


    }
}