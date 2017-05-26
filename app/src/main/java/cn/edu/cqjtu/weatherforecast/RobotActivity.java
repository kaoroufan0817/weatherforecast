package cn.edu.cqjtu.weatherforecast;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mySys on 2017/5/27.
 */

public class RobotActivity extends AppCompatActivity implements HttpGetDataListener ,View.OnClickListener{
    private HttpData httpData;//声明异步请求对象
    private List<ListData> lists;//创建集合来承载数据
    private ListView lv;
    private EditText sendtext;
    private Button send_btn;
    private String content_str;//自定义输入内容
    private TextAdapter adapter;
    private String[] welcome_array;
    private double currentTime;
    private double oldTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robot);
        initView();

    }

    private void initView(){
        lv = (ListView) findViewById(R.id.lv);
        sendtext = (EditText) findViewById(R.id.sendText);
        send_btn = (Button) findViewById(R.id.send_btn);
        lists = new ArrayList<ListData>();
        send_btn.setOnClickListener(this);
        adapter = new TextAdapter(lists,this);
        lv.setAdapter(adapter);
        ListData listData;//实现具体内容的封装 封装text
        listData = new ListData(getRandomWelcomeTips(),ListData.RECEIVER,getTime());
        lists.add(listData);
    }

    private String getRandomWelcomeTips(){
        String welcome_tip = null;
        welcome_array = this.getResources().getStringArray(R.array.welcome_tips);
        int index = (int) (Math.random()*(welcome_array.length-1));
        welcome_tip = welcome_array[index];
        return welcome_tip;
    }

    //复写接口中的抽象方法
    @Override
    public void getDataUrl(String data) {
        //System.out.println(data);
        parseText(data);
    }

    //解析文字
    public void parseText(String str){

        try {
            JSONObject jb = new JSONObject(str);
            //System.out.println(jb.getString("code"));
            //System.out.println(jb.getString("text"));
            ListData listData;//实现具体内容的封装 封装text
            listData = new ListData(jb.getString("text"),ListData.RECEIVER,getTime());
            lists.add(listData);
            adapter.notifyDataSetChanged();//需要点击时或系统返回时进行重新适配
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        getTime();
        content_str = sendtext.getText().toString();
        sendtext.setText("");
        String dorpb = content_str.replace(" ","");
        String dorpe = dorpb.replace("\n","");
        ListData listData;//实现具体内容的封装 封装text
        listData = new ListData(content_str,ListData.SEND,getTime());
        lists.add(listData);

        //防止lists过大
        if(lists.size()>30) {
            for(int i = 0;i<lists.size();i++){
                lists.remove(i);
            }
        }

        adapter.notifyDataSetChanged();//需要点击时或系统返回时进行重新适配 即刷新
        httpData = (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=c552f091699f4421989542293b35b085&info="
                +dorpe,this).execute();//实例化异步请求对象 并启动异步通信
    }

    //添加消息发送时间
    public String getTime(){
        currentTime = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");//以yyyy年MM月dd日 hh:mm:ss格式显示时间
        Date curDate = new Date();
        String str = format.format(curDate);
        if(currentTime - oldTime >= 5*60*1000){
            oldTime = currentTime;
            return str;
        }
        return "";
    }
}
