package com.example.hasee.a2048dome;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by hasee on 2018/3/13.
 */

public class Card extends FrameLayout{
    private TextView label;  //呈现的文字
    private int num = 0; //绑定的编号
    public Card(Context context) {
        super(context);
        label = new TextView(getContext());   //显示下
        label.setTextSize(32);
        label.setGravity(Gravity.CENTER);

        LayoutParams lp = new LayoutParams(-1,-1);  //创建个布局，填充满整个父局容器
        addView(label,lp);   //然后扔进去

        setNum(0);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;

        label.setText(num+"");
    }

    /**
     * 判断卡片的数字是否相同
     * @param o
     * @return
     */
    public boolean equals(Card o) {
        return getNum()==o.getNum();
    }
}
