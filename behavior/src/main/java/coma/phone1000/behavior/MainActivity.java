package coma.phone1000.behavior;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SwipeDismissBehavior.OnDismissListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * CoordinatorLayout 中的一个核心Behavior
     * 通过Behavior 控制我们的View
     * 使用的所有的属性就是我们协调者的LayoutParams
     *
     *
     */
    private void initView() {
        mText = (TextView) findViewById(R.id.teach_test_behaior);
        mText.setOnClickListener(this);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mText.getLayoutParams();
        SwipeDismissBehavior behavior = new SwipeDismissBehavior();
        behavior.setListener(this);
        layoutParams.setBehavior(behavior);

    }
    public void teachClick(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"我在这呢",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDismiss(final View view) {
        Log.e(TAG, "onDismiss: " );
        view.setVisibility(View.GONE);
        Snackbar.make(view,"撤销删除",Snackbar.LENGTH_LONG).setAction("确定",
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        view.setVisibility(View.VISIBLE);
                        //开启一个当前状态透明度到1的动画
                        ViewCompat.animate(view).alpha(1).start();
                    }
                }).show();
    }

    @Override
    public void onDragStateChanged(int state) {
        Log.e(TAG, "onDragStateChanged: " );

    }
}
