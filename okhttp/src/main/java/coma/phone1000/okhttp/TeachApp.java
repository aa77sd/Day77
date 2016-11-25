package coma.phone1000.okhttp;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;

import coma.phone1000.okhttp.constants.HttpParams;
import coma.phone1000.okhttp.utils.NetWorkUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 网络请求缓存本身是需要服务器支持的 服务器需要存在缓存参数 客户端才可以缓存
 * <p/>
 * okhttp 可以在请求前 以及请求后对数据进行包装
 * 可以去添加一些请求信息 来使我们的工具支持缓存
 * <p/>
 * Http传输的时候控制缓存的就存在头文件中
 * Cache—Control
 * Prama
 */
public class TeachApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        //初始化OKHttpClient
        //实例化请求缓存
        Cache cache = new Cache(getCacheDir(), 50 * 1024 * 1024);
        //添加网络拦截器
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取到这次的这个请求
                Request request = chain.request();
                if (!NetWorkUtil.isConnected(TeachApp.this)) {
                    request = request.newBuilder()
                            //当没有网络的时候  我们将请求设置为强制从缓冲中获取
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                //获取请求的Response
                Response response = chain.proceed(request);
                if (NetWorkUtil.isConnected(TeachApp.this)) {
                    //获取请求中的缓存规则
                    String cacheControl = request.cacheControl().toString();
                    response=response.newBuilder()
                            //修改response结构 让resource支持缓存的形式
                            .removeHeader(HttpParams.CACHE_CONTROL)
                            .removeHeader(HttpParams.PARMA)
                            .addHeader(HttpParams.CACHE_CONTROL,cacheControl)
                            .build();
                }else {
                    //没有网络的时候 缓存策略设置为直接从缓冲中获取 哪怕缓存是过期的
                    response=response.newBuilder()
                            .removeHeader(HttpParams.CACHE_CONTROL)
                            .removeHeader(HttpParams.PARMA)
                            //配置缓存策略 共有的仅从缓存中获取 可接受最大过期时间
                            .addHeader(HttpParams.CACHE_CONTROL,"public,only-if-cached,max-stale"+2*60*60)
                            .build();


                }



                return response;
            }
        };
        OkHttpClient client = new OkHttpClient.Builder()
                //添加缓存
                .cache(cache)
                //添加一个自定义的网络拦截器
                .addNetworkInterceptor(interceptor)

                .build();
        OkHttpUtils.initClient(client);

    }
    public static String getCacheControl(){
        return  NetWorkUtil.isConnected(context)?"max-age=60":"only-if-cache,max-stale="+2*60*60;
    }
}
