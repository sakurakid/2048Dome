package com.example.hasee.a2048dome;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * Created by hasee on 2018/3/13.
 * 游戏界面类
 */

public class GameView extends GridLayout {

    public GameView(Context context) {
        super(context);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initGameView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int cardWith = (Math.min(w,h)-10)/4;     //卡片的宽高

        addCards(cardWith,cardWith);
    }
    private void addCards(int cardWidth,int cardHeight){
        Card c;
        for(int y = 0;y< 4;y++){
            for(int x = 0;x < 4;x++){
                c = new Card(getContext());
                c.setNum(2);
                addView(c,cardWidth,cardHeight);

            }
        }

    }

    /**
     * 初始化
     */
    private void initGameView(){
        setColumnCount(4);  //指名是4列的
        setBackgroundColor(0xffbbada0);
        
        setOnTouchListener(new OnTouchListener() {
            private float startX,startY;//初始的位置
            private float offsetX,offsetY; //偏移的值

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX  = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offsetX = motionEvent.getX()-startX;
                        offsetY = motionEvent.getY()-startY;
                        if(Math.abs(offsetX)>Math.abs(offsetY)) {  //这个是防止斜着化
                            if (offsetX < -5) {
                                Log.d("233","left");
                                swipeLeft();

                            } else if (offsetX > 5) {
                                Log.d("233","right");
                                swipeRight();
                            }
                        }else {
                            if (offsetY < -5){
                                Log.d("233","up");
                                swipeUp();
                            }else if (offsetY>5){
                                Log.d("233", "down ");
                                swipeDown();
                            }
                        }
                        break;
                }
                return true;
            }
        });

    }

    private void swipeLeft(){
        Toast.makeText(getContext(), "向左滑动了",Toast.LENGTH_SHORT).show();
    }
    private void swipeRight(){
        Toast.makeText(getContext(), "向右滑动了", Toast.LENGTH_SHORT).show();
    }
    private void swipeUp(){
        Toast.makeText(getContext(), "向上滑动了",Toast.LENGTH_SHORT).show();
    }
    private void swipeDown(){
        Toast.makeText(getContext(), "向下滑动了",Toast.LENGTH_SHORT).show();
    }




}
