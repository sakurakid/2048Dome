package com.example.hasee.a2048dome;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView tvScrore;//计分的
    private int score = 0;

    private static MainActivity mainActivity = null;
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
        tvScrore = (TextView) findViewById(R.id.tvSorce);
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

    /**
     * 菜单、返回键响应
     */
    private long exitTime = 0;

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", 1000).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
