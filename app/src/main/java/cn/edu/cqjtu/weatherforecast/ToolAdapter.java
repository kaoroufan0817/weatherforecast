package cn.edu.cqjtu.weatherforecast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Created by mySys on 2017/5/26.
 */

public class ToolAdapter extends RecyclerView.Adapter<ToolAdapter.ViewHolder> {
    private List<Tool> mtoolList;
    private Context mContext;
    private int selected[] = {0,0,0,0,0,0,0,0,0};



    static class ViewHolder extends RecyclerView.ViewHolder {
        View toolView;
        ImageView toolImage;
        TextView toolName;

        public ViewHolder(View view) {
            super(view);
            toolView = view;
            toolImage = (ImageView) view.findViewById(R.id.tool_image);
            toolName = (TextView) view.findViewById(R.id.tool_name);
        }
    }

    public ToolAdapter(List<Tool> toolList,Context context) {
        mtoolList = toolList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tool_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.toolView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Tool tool = mtoolList.get(position);
                if (Activity.class.isInstance(mContext)) {
                    Activity activity = (Activity) mContext;

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
                    if(prefs.getString("nowPosition",null) != null){
                        selected[0] = Integer.parseInt(prefs.getString("button_1_status",null));
                        selected[1] = Integer.parseInt(prefs.getString("button_2_status",null));
                        selected[2] = Integer.parseInt(prefs.getString("button_3_status",null));
                        selected[3] = Integer.parseInt(prefs.getString("button_4_status",null));
                        selected[4] = Integer.parseInt(prefs.getString("button_5_status",null));
                        selected[5] = Integer.parseInt(prefs.getString("button_6_status",null));
                        selected[6] = Integer.parseInt(prefs.getString("button_7_status",null));
                        selected[7] = Integer.parseInt(prefs.getString("button_8_status",null));
                        selected[8] = Integer.parseInt(prefs.getString("button_9_status",null));
                    }
                    //        Toast.makeText(ncontext,"这里执行了",Toast.LENGTH_SHORT).show();

                    if (!isSelected(tool.getId())) {
                        Intent intent = new Intent();
                        intent.putExtra("num", tool.getId());
                        Toast.makeText(v.getContext(), "你选择了 " + tool.getName(), Toast.LENGTH_SHORT).show();
                        //在适配器中关闭活动

                        activity.setResult(RESULT_OK, intent);
                        activity.finish();
                    } else {
                        Toast.makeText(v.getContext(), "该工具已经添加。 ", Toast.LENGTH_SHORT).show();

                            activity.finish();
                        }
                    }

            }
        });
        holder.toolImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Tool tool = mtoolList.get(position);
                if (Activity.class.isInstance(mContext)) {
                    Activity activity = (Activity) mContext;

                    //Toast.makeText(mContext, "运行到这里", Toast.LENGTH_SHORT).show();
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
                    if(prefs.getString("nowPosition",null) != null){
                        selected[0] = Integer.parseInt(prefs.getString("button_1_status",null));
                        //Toast.makeText(mContext, "运行到这里", Toast.LENGTH_SHORT).show();
                        selected[1] = Integer.parseInt(prefs.getString("button_2_status",null));
                        selected[2] = Integer.parseInt(prefs.getString("button_3_status",null));
                        selected[3] = Integer.parseInt(prefs.getString("button_4_status",null));
                        selected[4] = Integer.parseInt(prefs.getString("button_5_status",null));
                        selected[5] = Integer.parseInt(prefs.getString("button_6_status",null));
                        selected[6] = Integer.parseInt(prefs.getString("button_7_status",null));
                        selected[7] = Integer.parseInt(prefs.getString("button_8_status",null));
                        selected[8] = Integer.parseInt(prefs.getString("button_9_status",null));
                    }

                    if (!isSelected(tool.getId())) {
                        Intent intent = new Intent();
                        intent.putExtra("num", tool.getId());
                        Toast.makeText(v.getContext(), "你选择了 " + tool.getName(), Toast.LENGTH_SHORT).show();
                        //在适配器中关闭活动

                        activity.setResult(RESULT_OK, intent);
                        activity.finish();
                    } else {
                        Toast.makeText(v.getContext(), "该工具已经添加。 ", Toast.LENGTH_SHORT).show();

                        activity.finish();
                    }
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tool tool = mtoolList.get(position);
        holder.toolImage.setImageResource(tool.getImageId());
        holder.toolName.setText(tool.getName());
    }

    @Override
    public int getItemCount() {
        return mtoolList.size();
    }

    public boolean isSelected(int num){

        for (int i = 0 ;i < 9;i++){
            if (selected[i] == num){
                //Toast.makeText(mContext, "有了。 ", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }
}


