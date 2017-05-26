package cn.edu.cqjtu.weatherforecast;

/**
 * Created by mySys on 2017/5/27.
 */
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

public class HttpData extends AsyncTask<String,Void,String> {

    private HttpClient mHttpClient;//通过HttpClient来进行请求
    private HttpGet mHttpGet;//文档要求为get请求方式
    private HttpResponse mHttpResponse;
    private HttpEntity mHttpEntity;//创建Http实体
    private InputStream in;//将所得数据转换为流文件
    private HttpGetDataListener listener;//实现自定义接口 并将该方法作为参数进行传递

    private String url;

    public HttpData(String url,HttpGetDataListener listener){
        this.url = url;
        this.listener = listener;
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            mHttpClient = new DefaultHttpClient();
            mHttpGet = new HttpGet(url);//实例化Httpget来请求 需要具体url
            mHttpResponse = mHttpClient.execute(mHttpGet);
            mHttpEntity = mHttpResponse.getEntity();//通过Response对象来获取数据
            in = mHttpEntity.getContent();//通过Http的实体来获得内容
            BufferedReader br = new BufferedReader(new InputStreamReader(in)); //创建缓冲区
            String line = null;
            StringBuffer sb = new StringBuffer();//储存所有的数据
            //通过while循环进行读取
            while ((line = br.readLine()) != null){
                sb.append(line);//读取到的数据存到String Buffer中
            }
            return sb.toString();//转换为String类型
        }catch(Exception e){

        }
        return null;
    }

    //以上获取数据
    @Override
    protected void onPostExecute(String result) {
        listener.getDataUrl(result);//把数据返回
        super.onPostExecute(result);
    }
}