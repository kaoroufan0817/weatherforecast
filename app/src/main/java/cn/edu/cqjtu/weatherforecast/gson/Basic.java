package cn.edu.cqjtu.weatherforecast.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mySys on 2017/5/25.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    //将不能作为java字段命名的JSON字段建立两者的映射关系

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
