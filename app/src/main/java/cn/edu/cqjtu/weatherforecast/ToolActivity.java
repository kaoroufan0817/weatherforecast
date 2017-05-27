package cn.edu.cqjtu.weatherforecast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by mySys on 2017/5/26.
 */

public class ToolActivity extends AppCompatActivity {

    //如果有缓存数据则直接显示


    private int button_1_status = 0;
    private int button_2_status = 0;
    private int button_3_status = 0;
    private int button_4_status = 0;
    private int button_5_status = 0;
    private int button_6_status = 0;
    private int button_7_status = 0;
    private int button_8_status = 0;
    private int button_9_status = 0;

    //表示哪个按钮是添加符号
    private int nowPosition = 1;

    //表示哪个按钮被按到
    private int click = 0;

    //表示返回了哪个工具Id
    private int returnId = 0;

    private ImageButton tool1;
    private ImageButton tool2;
    private ImageButton tool3;
    private ImageButton tool4;
    private ImageButton tool5;
    private ImageButton tool6;
    private ImageButton tool7;
    private ImageButton tool8;
    private ImageButton tool9;

    private ImageButton weatherButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);

        tool1 = (ImageButton) findViewById(R.id.tool_1);
        tool2 = (ImageButton) findViewById(R.id.tool_2);
        tool3 = (ImageButton) findViewById(R.id.tool_3);
        tool4 = (ImageButton) findViewById(R.id.tool_4);
        tool5 = (ImageButton) findViewById(R.id.tool_5);
        tool6 = (ImageButton) findViewById(R.id.tool_6);
        tool7 = (ImageButton) findViewById(R.id.tool_7);
        tool8 = (ImageButton) findViewById(R.id.tool_8);
        tool9 = (ImageButton) findViewById(R.id.tool_9);


        weatherButton = (ImageButton) findViewById(R.id.weather_button);

        //tool2.setImageDrawable(getResources().getDrawable(R.drawable.add_button));

        loadStatus();

        setOnClickListener();
        setButtonEnabled();
        setAddSignal();

        reFreshToolSignal(tool1,button_1_status);
        reFreshToolSignal(tool2,button_2_status);
        reFreshToolSignal(tool3,button_3_status);
        reFreshToolSignal(tool4,button_4_status);
        reFreshToolSignal(tool5,button_5_status);
        reFreshToolSignal(tool6,button_6_status);
        reFreshToolSignal(tool7,button_7_status);
        reFreshToolSignal(tool8,button_8_status);
        reFreshToolSignal(tool9,button_9_status);


        weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ToolActivity.this,WeatherActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }//onCreat方法结束

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Toast.makeText(ToolActivity.this,"这里执行了",Toast.LENGTH_SHORT).show();
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    //Toast.makeText(ToolActivity.this,"这里执行了",Toast.LENGTH_SHORT).show();
                    returnId = data.getIntExtra("num",0);
                    //Toast.makeText(ToolActivity.this,returnId,Toast.LENGTH_SHORT).show();
                    //tool2.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
                    processReturnId(returnId);
                    saveStatus();
                    reFreshTool();
                }break;
            default:
        }
    }//onActivityResult方法结束



    public void reFreshTool(){
        setButtonEnabled();
        setAddSignal();
        setButtonEnabled();
    }



    //处理returnId
    public void processReturnId(int id){
        if(id == 0){
            return;
        }else if (click == 1){
            button_1_status = id;
            reFreshToolSignal(tool1,id);
        }else if (click == 2){
            button_2_status = id;
            reFreshToolSignal(tool2,id);
        }else if (click == 3){
            button_3_status = id;
            reFreshToolSignal(tool3,id);
        }else if (click == 4){
            button_4_status = id;
            reFreshToolSignal(tool4,id);
        }else if (click == 5){
            button_5_status = id;
            reFreshToolSignal(tool5,id);
        }else if (click == 6){
            button_6_status = id;
            reFreshToolSignal(tool6,id);
        }else if (click == 7){
            button_7_status = id;
            reFreshToolSignal(tool7,id);
        }else if (click == 8){
            button_8_status = id;
            reFreshToolSignal(tool8,id);
        }else if (click == 9){
            button_9_status = id;
            reFreshToolSignal(tool9,id);
        }
        nowPosition++;
        if(nowPosition > 9){
            Toast.makeText(ToolActivity.this,"工具栏已满",Toast.LENGTH_SHORT).show();
        }
    }

    //设置监听器
        public void setOnClickListener(){
            tool1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 1;
                    linkFunction(button_1_status);
                }
            });

            tool2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 2;
                    linkFunction(button_2_status);
                }
            });

            tool3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 3;
                    linkFunction(button_3_status);
                }
            });

            tool4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 4;
                    linkFunction(button_4_status);
                }
            });

            tool5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 5;
                    linkFunction(button_5_status);
                }
            });

            tool6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 6;
                    linkFunction(button_6_status);
                }
            });

            tool7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 7;
                    linkFunction(button_7_status);
                }
            });

            tool8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 8;
                    linkFunction(button_8_status);
                }
            });

            tool9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click = 9;
                    linkFunction(button_9_status);
                }
            });
        }

        //刷新工具图标
        public void reFreshToolSignal(ImageButton imageButton,int num){
            if (num == 0){}
            else if(num == 1){
                imageButton.setImageDrawable(getResources().getDrawable(R.drawable.assistant));
            }
            else if(num == 2){
                imageButton.setImageDrawable(getResources().getDrawable(R.drawable.location));
            }
            else if(num == 3){}
            else if(num == 4){}
            else if(num == 5){}
            else if(num == 6){}
            else if(num == 7){}
            else if(num == 8){}
            else if(num == 9){}
        }

        //建立按钮与活动关系
        public void linkFunction(int num) {
            if (num == 0){
                Intent intent = new Intent(ToolActivity.this, ChooseToolActivity.class);
                startActivityForResult(intent,1);
            } else if (num == 1) {
                Intent intent = new Intent(ToolActivity.this, RobotActivity.class);
                startActivity(intent);
            } else if (num == 2) {
                Intent intent = new Intent(ToolActivity.this, LBSActivity.class);
                startActivity(intent);
            } else if (num == 3) {

            } else if (num == 4) {

            } else if (num == 5) {

            } else if (num == 6) {

            } else if (num == 7) {

            } else if (num == 8) {

            } else if (num == 9) {

            }
        }

        //设置添加符号
        public void setAddSignal(){
        for (int i = 0;i < 9;i++)
        {
            if (nowPosition == 1){
                tool1.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 2){
                tool2.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 3){
                tool3.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 4){
                tool4.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 5){
                tool5.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 6){
                tool6.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 7){
                tool7.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 8){
                tool8.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
            if (nowPosition == 9){
                tool9.setImageDrawable(getResources().getDrawable(R.drawable.add_button));
            }
        }
    }

        //设置按钮不可用
        public void setButtonEnabled(){

            for (int i = 0;i < 9;i++)
            {
                tool1.setEnabled(true);
                tool2.setEnabled(true);
                tool3.setEnabled(true);
                tool4.setEnabled(true);
                tool5.setEnabled(true);
                tool6.setEnabled(true);
                tool7.setEnabled(true);
                tool8.setEnabled(true);
                tool9.setEnabled(true);
                if (button_1_status == 0 && nowPosition != 1){
                    tool1.setEnabled(false);
                }
                if (button_2_status == 0 && nowPosition != 2){
                    tool2.setEnabled(false);
                }
                if (button_3_status == 0 && nowPosition != 3){
                    tool3.setEnabled(false);
                }
                if (button_4_status == 0 && nowPosition != 4){
                    tool4.setEnabled(false);
                }
                if (button_5_status == 0 && nowPosition != 5){
                    tool5.setEnabled(false);
                }
                if (button_6_status == 0 && nowPosition != 6){
                    tool6.setEnabled(false);
                }
                if (button_7_status == 0 && nowPosition != 7){
                    tool7.setEnabled(false);
                }
                if (button_8_status == 0 && nowPosition != 8){
                    tool8.setEnabled(false);
                }
                if (button_9_status == 0 && nowPosition != 9){
                    tool9.setEnabled(false);
                }

            }
        }
    
        //存储状态
    public void saveStatus(){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(ToolActivity.this).edit();
        editor.putString("button_1_status", String.valueOf(button_1_status));
        editor.putString("button_2_status", String.valueOf(button_2_status));
        editor.putString("button_3_status", String.valueOf(button_3_status));
        editor.putString("button_4_status", String.valueOf(button_4_status));
        editor.putString("button_5_status", String.valueOf(button_5_status));
        editor.putString("button_6_status", String.valueOf(button_6_status));
        editor.putString("button_7_status", String.valueOf(button_7_status));
        editor.putString("button_8_status", String.valueOf(button_8_status));
        editor.putString("button_9_status", String.valueOf(button_9_status));
        editor.putString("nowPosition", String.valueOf(nowPosition));
        editor.apply();
    }

    //读取状态
    public void loadStatus(){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(prefs.getString("nowPosition",null) != null){
            button_1_status = Integer.parseInt(prefs.getString("button_1_status",null));
            button_2_status = Integer.parseInt(prefs.getString("button_2_status",null));
            button_3_status = Integer.parseInt(prefs.getString("button_3_status",null));
            button_4_status = Integer.parseInt(prefs.getString("button_4_status",null));
            button_5_status = Integer.parseInt(prefs.getString("button_5_status",null));
            button_6_status = Integer.parseInt(prefs.getString("button_6_status",null));
            button_7_status = Integer.parseInt(prefs.getString("button_7_status",null));
            button_8_status = Integer.parseInt(prefs.getString("button_8_status",null));
            button_9_status = Integer.parseInt(prefs.getString("button_9_status",null));
            nowPosition = Integer.parseInt(prefs.getString("nowPosition",null));
        }
    }
}

