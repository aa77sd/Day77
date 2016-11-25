package coma.phone1000.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ZZY on 2016/11/25.
 */
public class TeachBehavior extends CoordinatorLayout.Behavior {
    private static final String TAG = TeachBehavior.class.getSimpleName();

    public TeachBehavior() {
    }

    public TeachBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *判定是否关注 嵌套滚动事件 true代表关注 flash 不关注
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.e(TAG, "onStartNestedScroll: " );
        return true;
    }

    /**
     *与onStartNestedScroll配对使用的 关注滚动事件 在滚动的时候做一些事情
     */
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        Log.e(TAG, "onNestedPreScroll: "+coordinatorLayout );
        Log.e(TAG, "onNestedPreScroll: "+child );
        Log.e(TAG, "onNestedPreScroll: "+target );
        Log.e(TAG, "onNestedPreScroll: "+dx );
        Log.e(TAG, "onNestedPreScroll: "+dy );
        Log.e(TAG, "onNestedPreScroll: "+consumed );
        if (dy>0) {
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }else {
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        }
    }
}

