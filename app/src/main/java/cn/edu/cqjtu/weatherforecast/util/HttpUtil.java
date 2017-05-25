package cn.edu.cqjtu.weatherforecast.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by mySys on 2017/5/24.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();//实例化OkHttpClient
        Request request = new Request.Builder().url(address).build();//创建Request对象
        client.newCall(request).enqueue(callback);//client发送请求并将结果入列
    }
}
