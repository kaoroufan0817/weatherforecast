package cn.edu.cqjtu.weatherforecast;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mySys on 2017/5/26.
 */

public class ChooseToolActivity extends Activity {



    private List<Tool> toolList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置窗口没有标题  
        setContentView(R.layout.activity_choose_tool);
        initTools();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        ToolAdapter adapter = new ToolAdapter(toolList,ChooseToolActivity.this);
        recyclerView.setAdapter(adapter);


    }

    private void initTools() {
        for (int i = 0; i < 2; i++) {
            Tool assistant = new Tool("机器人助手", R.drawable.assistant,1);
            toolList.add(assistant);
            Tool location = new Tool("地图位置", R.drawable.location,2);
            toolList.add(location);
            Tool test2 = new Tool("Orange", R.drawable.ic_home,3);
            toolList.add(test2);
        }
    }

}
