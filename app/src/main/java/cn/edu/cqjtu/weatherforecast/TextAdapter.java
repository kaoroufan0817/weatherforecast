package cn.edu.cqjtu.weatherforecast;

/**
 * Created by mySys on 2017/5/27.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;
public class TextAdapter extends BaseAdapter{

    private List<ListData> lists;//给它集合的数据内容
    private Context mContext;
    private RelativeLayout layout;

    public TextAdapter(List<ListData> lists,Context mContext){
        this.lists = lists;
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return lists.size();//当前ListView所能承载的条数 返回lists数据整体的数量
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        //加载哪一个view要依靠状态来决定
        if(lists.get(position).getFlag() == ListData.RECEIVER){
            layout = (RelativeLayout) inflater.inflate(R.layout.leftitem,null);
        }
        else if(lists.get(position).getFlag() == ListData.SEND){
            layout = (RelativeLayout) inflater.inflate(R.layout.rightitem,null);
        }

        TextView tv = (TextView) layout.findViewById(R.id.tv);
        TextView time = (TextView) layout.findViewById(R.id.time);
        tv.setText(lists.get(position).getContent());
        time.setText(lists.get(position).getTime());
        return layout;
    }
}