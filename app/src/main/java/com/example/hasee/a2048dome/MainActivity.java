package com.example.hasee.a2048dome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvScrore;//计分的
    private static MainActivity mainActivity = null;
    private int score = 0;


   public MainActivity(){
       mainActivity = this;
   }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tvScrore = findViewById(R.id.tvSorce);
    }

    public void clearScore(){
        score = 0;
        showScore();
    }
    public void showScore(){
        tvScrore.setText(score+"");
    }
    public void addScore(int s){
        score+=s;
        showScore();
    }
}
