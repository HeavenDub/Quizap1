package com.quizp.quizp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonGame extends AppCompatActivity {
    CircularProgressBar circularprogress;
    TextView resulttext;
    LinearLayout sharebtn;
    int correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won_game);
        correct=getIntent().getIntExtra("correctcmpt",0);
        wrong=getIntent().getIntExtra("wrongcmpt",0);
        circularprogress = findViewById(R.id.circularprogress);
        resulttext = findViewById(R.id.resulttext);
        sharebtn=findViewById(R.id.sharebtn);
        circularprogress.setProgress(correct);
        resulttext.setText(correct+"/10");
        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nI got "+correct+"Out of 10, You can also try the quiz";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });




    }
}