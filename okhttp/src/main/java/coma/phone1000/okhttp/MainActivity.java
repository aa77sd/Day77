package coma.phone1000.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import coma.phone1000.okhttp.constants.HttpParams;
import okhttp3.Call;

/**
 *
 */

public class MainActivity extends AppCompatActivity {

    private static final String GET_UTL = "http://app.vmoiver.com/apiv3/post/getPostInCate?cateid=0&p=1";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testClick(View view) {
        switch (view.getId()) {
            case R.id.teach_get_net:
                OkHttpUtils.get()
                        .url(GET_UTL)
                        .addHeader(HttpParams.CACHE_CONTROL,"max-age=60")
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Log.e(TAG, "onError: " );
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.e(TAG, "onResponse: "+response );
                            }
                        });
                break;

            case R.id.teach_get_cache:
                OkHttpUtils.get()
                        .url(GET_UTL)
                        //最大过期时间
                        .addHeader(HttpParams.CACHE_CONTROL,"only-if-cache,max-stale="+2*60*60)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Log.e(TAG, "onError: " );

                            }

                            @Override
                            public void onResponse(String response, int id) {

                                Log.e(TAG, "onResponse: "+response );
                            }
                        });



                break;
            case R.id.teach_get_auto:

                OkHttpUtils.get()
                        .url(GET_UTL)
                        .addHeader(HttpParams.CACHE_CONTROL,TeachApp.getCacheControl())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                Log.e(TAG, "onError: " );
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.e(TAG, "onResponse: " );
                            }
                        });
                break;
        }
    }
}
