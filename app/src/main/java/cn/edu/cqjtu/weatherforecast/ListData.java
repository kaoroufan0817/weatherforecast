package cn.edu.cqjtu.weatherforecast;

/**
 * Created by mySys on 2017/5/27.
 */

//将获得的数据封装起来
public class ListData {

    public static final int SEND = 1;
    public static final int RECEIVER = 2;
    private int flag;
    private String time;

    private String content;

    public ListData(String content,int flag,String time){
        setContent(content);
        setFlag(flag);
        setTime();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public int getFlag(){
        return flag;
    }
    public void setFlag(int flag){
        this.flag = flag;
    }
    public String getTime(){
        return time;
    }
    public void setTime(){
        this.time = time;
    }
}