package com.quizp.quizp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Collections;


public class Dashboard extends AppCompatActivity {

    ProgressBar progressBar;
    public int timervalue = 20;
    CountDownTimer countdowntimer;
    int i;
    ModelClass modelclass;
    TextView cardquest, option1, option2, option3, option4;
    CardView Cardoption1, Cardoption2, Cardoption3, Cardoption4;
    LinearLayout nextbtn;
    int correctcmpt=0;
    int wrongcmpt=0;

    @Override
    public void onBackPressed() {
    }

    private void setAllData() {
        cardquest.setText(modelclass.getQuestion());
        option1.setText(modelclass.getOp1());
        option2.setText(modelclass.getOp2());
        option3.setText(modelclass.getOp3());
        option4.setText(modelclass.getOp4());
    }
    private void disableBtns() {
        Cardoption1.setClickable(false);
        Cardoption2.setClickable(false);
        Cardoption3.setClickable(false);
        Cardoption4.setClickable(false);
    }

    private void enableBtns() {
        Cardoption1.setClickable(true);
        Cardoption2.setClickable(true);
        Cardoption3.setClickable(true);
        Cardoption4.setClickable(true);
    }

    private void Hooks() {

        progressBar = findViewById(R.id.progressbar);
        cardquest = findViewById(R.id.cardquest);
        option1 = findViewById(R.id.cardopt1);
        option2 = findViewById(R.id.cardopt2);
        option3 = findViewById(R.id.cardopt3);
        option4 = findViewById(R.id.cardopt4);
        Cardoption1 = findViewById(R.id.card1);
        Cardoption2 = findViewById(R.id.card2);
        Cardoption3 = findViewById(R.id.card3);
        Cardoption4 = findViewById(R.id.card4);
        nextbtn = findViewById(R.id.nextbtn);

    }
    private void gameWon() {
        Intent inte=new Intent(getApplicationContext(),WonGame.class);
        inte.putExtra("correctcmpt",correctcmpt);
        inte.putExtra("wrongcmpt",wrongcmpt);
        startActivity(inte);

    }
    private void resetColors(){
        Cardoption1.setBackgroundColor(getColor(R.color.white));
        Cardoption2.setBackgroundColor(getColor(R.color.white));
        Cardoption3.setBackgroundColor(getColor(R.color.white));
        Cardoption4.setBackgroundColor(getColor(R.color.white));
    }


    public void Correct(CardView cardView){
        cardView.setBackgroundColor(getColor(R.color.right));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timervalue=20;
                correctcmpt++;
                if(i<MainActivity.Listofq.size()-1){

                i++;
                modelclass = MainActivity.Listofq.get(i);
                    setAllData();
                    enableBtns();
                    resetColors();

                }else{
                    gameWon();
                }

            }
        });}

        public void Wrong(CardView cardView){
            cardView.setBackgroundColor(getColor(R.color.wrong));
            nextbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timervalue=20;
                    wrongcmpt++;
                    if(i<MainActivity.Listofq.size()-1){

                        i++;
                        modelclass = MainActivity.Listofq.get(i);
                        setAllData();
                        enableBtns();
                        resetColors();

                    }else{
                        gameWon();
                    }

                }
            });



    }

    public void option1Click(View view) {
        disableBtns();
        nextbtn.setClickable(true);
        if(modelclass.getOp1().equals(modelclass.getAnswer())) {


            Correct(Cardoption1);


        }else{

            Wrong(Cardoption1);


        }



    }

    public void option2Click(View view) {
        disableBtns();
        nextbtn.setClickable(true);
        if(modelclass.getOp2().equals(modelclass.getAnswer())) {

            Correct(Cardoption2);



        }else{

            Wrong(Cardoption2);


        }




    }


    public void option3Click(View view) {
        disableBtns();
        nextbtn.setClickable(true);
        if(modelclass.getOp3().equals(modelclass.getAnswer())) {
            Correct(Cardoption3);

        }else{
            Wrong(Cardoption3);
        }



    }

    public void option4Click(View view) {
        disableBtns();
        nextbtn.setClickable(true);
        if(modelclass.getOp4().equals(modelclass.getAnswer())) {

            Correct(Cardoption4);



        }else{

            Wrong(Cardoption4);


        }





    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);
            modelclass = MainActivity.Listofq.get(i);
            Collections.shuffle(MainActivity.Listofq);
            Hooks();
            setAllData();
            nextbtn.setClickable(false);
            progressBar = findViewById(R.id.progressbar);
            countdowntimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue = timervalue - 1;
                progressBar.setProgress(timervalue);

            }

            @Override
            public void onFinish() {
                LayoutInflater layoutInflater = LayoutInflater.from(Dashboard.this);
                View promptView = layoutInflater.inflate(R.layout.timeout_dialog, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(Dashboard.this);
                dialog.setView(promptView);
                LinearLayout tryagainbtn = (LinearLayout) promptView.findViewById(R.id.tryagainbtn);
                tryagainbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Dashboard.this, MainActivity.class);
                        startActivity(i);
                    }
                });
                dialog.show();


            }
        }.start();

    }








}

