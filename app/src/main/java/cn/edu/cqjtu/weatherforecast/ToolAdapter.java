package cn.edu.cqjtu.weatherforecast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
                if (!isSelected(tool.getId())) {
                    Intent intent = new Intent();
                    intent.putExtra("num", tool.getId());
                    Toast.makeText(v.getContext(), "你选择了 " + tool.getName(), Toast.LENGTH_SHORT).show();
                    //在适配器中关闭活动
                    if (Activity.class.isInstance(mContext)) {
                        Activity activity = (Activity) mContext;
                        activity.setResult(RESULT_OK, intent);
                        activity.finish();
                    }
                } else {
                    Toast.makeText(v.getContext(), "该工具已经添加。 ", Toast.LENGTH_SHORT).show();
                    if (Activity.class.isInstance(mContext)) {
                        Activity activity = (Activity) mContext;
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
                if (!isSelected(tool.getId())) {
                    Intent intent = new Intent();
                    intent.putExtra("num", tool.getId());
                    Toast.makeText(v.getContext(), "你选择了 " + tool.getName(), Toast.LENGTH_SHORT).show();
                    //在适配器中关闭活动
                    if (Activity.class.isInstance(mContext)) {
                        Activity activity = (Activity) mContext;
                        activity.setResult(RESULT_OK, intent);
                        activity.finish();
                    }
                } else {
                    Toast.makeText(v.getContext(), "该工具已经添加。 ", Toast.LENGTH_SHORT).show();
                    if (Activity.class.isInstance(mContext)) {
                        Activity activity = (Activity) mContext;
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
                return true;
            }
        }
        return false;
    }
}
