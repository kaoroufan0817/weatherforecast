package cn.edu.cqjtu.weatherforecast;

/**
 * Created by mySys on 2017/5/27.
 */

//将数据使其他页面可以使用 来创建一个接口
public interface HttpGetDataListener {
    void getDataUrl(String data);
}
