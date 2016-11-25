package coma.phone1000.day77.widget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import coma.phone1000.day77.R;

/**
 * Created by ZZY on 2016/11/25.
 */
public class TopBar extends FrameLayout{


    private TextView mLeft;
    private TextView mTitle;
    private TextView mRight;

    public TopBar(Context context) {
        this(context,null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //构造入口 在这里面进行初始化
        //第三个参数 是否依附在父控件上

//        View inflate = LayoutInflater.from(context).inflate(R.layout.topbar, this, false);
//        addView(inflate);
        LayoutInflater.from(context).inflate(R.layout.topbar,this,true);
        mLeft = (TextView) findViewById(R.id.teach_topbar_left);
        mTitle = (TextView) findViewById(R.id.teach_topbar_title);
        mRight = (TextView) findViewById(R.id.teach_topbar_right);

    }
    public void setTitle(CharSequence title){
        mTitle.setVisibility(VISIBLE);
        mTitle.setText(title);

    }

    public void setTitle(int stringResId){
        mTitle.setVisibility(VISIBLE);
        mTitle.setText(stringResId);
    }
    public void setBack(final Context context){
        mLeft.setVisibility(VISIBLE);
        mLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) context).finish();
            }
        });
    }

    public void setLeft(OnClickListener listener){
        mLeft.setVisibility(VISIBLE);
        mLeft.setOnClickListener(listener);
    }
    public  void setRight(final Context context){
        mRight.setVisibility(VISIBLE);
        mRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((AppCompatActivity) context).setTitle("nihao");
            }
        });

    }
}
