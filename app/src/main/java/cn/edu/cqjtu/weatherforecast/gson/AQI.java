package cn.edu.cqjtu.weatherforecast.gson;

/**
 * Created by mySys on 2017/5/25.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
