package cn.edu.cqjtu.weatherforecast.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mySys on 2017/5/25.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;
    public class More{
        @SerializedName("txt")
        public String info;
    }
}
