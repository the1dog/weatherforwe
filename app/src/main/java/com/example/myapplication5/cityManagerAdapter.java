package com.example.myapplication5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication5.bean.WeatherBean;
import com.example.myapplication5.data.Databasebean;
import com.google.gson.Gson;

import java.util.List;

public class cityManagerAdapter extends BaseAdapter {
    Context context;
    List<Databasebean>mDatas;

    public cityManagerAdapter(Context context, List<Databasebean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        viewHolder holder=null;
        if (convertView==null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_city_manager,null);
            holder=new viewHolder(convertView);
            convertView.setTag(holder);

        }else {
            holder=(viewHolder) convertView.getTag();
        }
        //设置对应数据
        Databasebean bean=mDatas.get(position);
        holder.cityTv.setText(bean.getCity());
        //解析
        WeatherBean weatherBean = new Gson().fromJson(bean.getContent(), WeatherBean.class);
        //今日
        WeatherBean.ResultsBean.WeatherDataBean dataBean = weatherBean.getResults().get(0).getWeather_data().get(0);
        holder.conTv.setText("天气:"+dataBean.getWeather());
        String[] split = dataBean.getDate().split("：");
        String todaytemp=split[1].replace(")","");
        holder.tempTv.setText(todaytemp);
        holder.windTv.setText(dataBean.getWind());
        holder.temprangeTv.setText(dataBean.getTemperature());


        return null;
    }



    class viewHolder{
        TextView cityTv,conTv,tempTv,windTv,temprangeTv;
        public viewHolder(View itemview){
            cityTv=itemview.findViewById(R.id.item_city_tv_city);
            conTv=itemview.findViewById(R.id.item_city_tv_condition);
            tempTv=itemview.findViewById(R.id.item_city_tv_temp);
            windTv=itemview.findViewById(R.id.item_city_wind);
            temprangeTv=itemview.findViewById(R.id.frag_tv_temprange);
        }
    }
}
