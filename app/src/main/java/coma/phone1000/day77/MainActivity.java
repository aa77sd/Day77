package coma.phone1000.day77;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import coma.phone1000.day77.widget.TopBar;

/**
 * View的绘制流程
 * 1 测量 onMeasure
 * 2 摆放 onLayout
 * 3 绘制 onDraw
 *
 *
 * 自定义View实现方式
 * 1继承自己有的View 进行绘制 比如直接继承自TextView 进行样式定制
 * 2继承自View 或ViewGroup进行绘制 LetterView FlowLayout
 * 3继承自已有ViewGroup子类 直接将子控件依附在ViewGroup上 组成一个新的View
 */

public class MainActivity extends AppCompatActivity {


    private TopBar mTopBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTopBar = (TopBar) findViewById(R.id.teach_topbar);
        mTopBar.setBack(this);
        mTopBar.setTitle("nihao");
        mTopBar.setRight(this);

    }
}
