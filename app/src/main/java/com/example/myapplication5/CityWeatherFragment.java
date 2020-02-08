package com.example.myapplication5;


import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication5.bean.WeatherBean;
import com.example.myapplication5.data.Datamanager;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityWeatherFragment extends BaseFragment implements  View.OnClickListener{
    TextView tempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,carIndexTv,coldIndexTv,sportIndexTv,raysIndexTv;
    ImageView dayIv;
    LinearLayout futureLayout;
    String url1="http://api.map.baidu.com/telematics/v3/weather?location=";
    String url2="&output=json&ak=FkPhtMBK0HTIQNh7gG4cNUttSTyr0nzo";
    private List<WeatherBean.ResultsBean.IndexBean> indexList;
    String city;
    public CityWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_city_weather, container, false);
        intView(view);
        //可以通过activity传值获取到当前fragment加载的是哪个地方的天气情况

        Bundle bundle=getArguments();
        city = bundle.getString("city");
        String url=url1+city+url2;
//调用父类的获取数据的方法
        loadData(url);
        return view;
    }

    @Override
    public void onSuccess(String result) {
//解析并展示数据
        parseShowData(result);
        //更新数据
        int i = Datamanager.updateInfoByCity(city, result);
        if(i<=0){
            //无数据更新，失败，无城市，增加这个城市记录
            Datamanager.addCityInfo(city,result);
        }

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        //数据库中查找上一次信息显示在fragment
        String s = Datamanager.queryInfoByCity(city);
        if (!TextUtils.isEmpty(s)) {
            parseShowData(s);
        }
    }

    private void parseShowData(String result) {
        //使用gson 解析数据
        WeatherBean weatherBean = new Gson().fromJson(result, WeatherBean.class);
        WeatherBean.ResultsBean resultsBean = weatherBean.getResults().get(0);
        //获取指数信息列表
        indexList = resultsBean.getIndex();
        //设置textview
        dateTv.setText(weatherBean.getDate());
        cityTv.setText(resultsBean.getCurrentCity());
        //获取今日天气情况
        WeatherBean.ResultsBean.WeatherDataBean todayDataBean = resultsBean.getWeather_data().get(0);
        windTv.setText(todayDataBean.getWind());
        tempRangeTv.setText(todayDataBean.getTemperature());
        conditionTv.setText(todayDataBean.getWeather());
        //获取实时天气情况
        String[] split = todayDataBean.getDate().split("：");
        String todayTemp = split[1].replace(")","");
        tempTv.setText(todayTemp);
        //设置显示的天气情况图片
        Picasso.with(getActivity()).load(todayDataBean.getDayPictureUrl()).into(dayIv);
        //获取未来三天的天气情况加载到layout
        List<WeatherBean.ResultsBean.WeatherDataBean> futureList = resultsBean.getWeather_data();
        futureList.remove(0);
        for(int i=0;i<futureList.size();i++){
            View itemview = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center, null);
            //设置高度
            itemview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            futureLayout.addView(itemview);
            TextView idateTv=itemview.findViewById(R.id.item_center_tv_date);
            TextView iconTv=itemview.findViewById(R.id.item_center_tv_con);
            TextView itemprangeTv=itemview.findViewById(R.id.item_center_tv_temp);
            ImageView iTv=itemview.findViewById(R.id.item_center_iv);
            //获取对应位置的天气情况
            WeatherBean.ResultsBean.WeatherDataBean dataBean=futureList.get(i);
            idateTv.setText(dataBean.getDate());
            iconTv.setText(dataBean.getWeather());
            itemprangeTv.setText(dataBean.getTemperature());
            Picasso.with(getActivity()).load(dataBean.getDayPictureUrl()).into(iTv);



        }

    }

    private void intView(View view) {
        //初始化控件
        tempTv=view.findViewById(R.id.frag_tv_currenttemp);
        cityTv=view.findViewById(R.id.frag_tv_city);
        conditionTv=view.findViewById(R.id.frag_tv_condition);
        windTv=view.findViewById(R.id.frag_tv_wind);
        tempRangeTv=view.findViewById(R.id.frag_tv_temprange);
        dateTv=view.findViewById(R.id.frag_tv_date);
        clothIndexTv=view.findViewById(R.id.frag_index_tv_dress);
        carIndexTv=view.findViewById(R.id.frag_index_tv_washcar);
        coldIndexTv=view.findViewById(R.id.frag_index_tv_cold);
        sportIndexTv=view.findViewById(R.id.frag_index_tv_sport);
        raysIndexTv=view.findViewById(R.id.frag_index_tv_rays);
        dayIv=view.findViewById(R.id.frag_tv_today);
        futureLayout=view.findViewById(R.id.frag_center_layout);
        //设置点击事件的监听
        clothIndexTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (v.getId()){
            case R.id.frag_index_tv_dress:
                builder.setTitle("穿衣指数");
                WeatherBean.ResultsBean.IndexBean indexBean = indexList.get(0);
                String msg=indexBean.getZs()+"\n"+indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);

                break;
            case R.id.frag_index_tv_washcar:
                builder.setTitle("洗车指数");
                indexBean = indexList.get(1);
                msg=indexBean.getZs()+"\n"+indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);
                break;
            case R.id.frag_index_tv_cold:
                builder.setTitle("感冒指数");
                indexBean = indexList.get(2);
                msg=indexBean.getZs()+"\n"+indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);break;
            case R.id.frag_index_tv_sport:

                builder.setTitle("运动指数");
                indexBean = indexList.get(3);
                msg=indexBean.getZs()+"\n"+indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);break;
            case R.id.frag_index_tv_rays:
                builder.setTitle("紫外线指数");
                indexBean = indexList.get(4);
                msg=indexBean.getZs()+"\n"+indexBean.getDes();
                builder.setMessage(msg);
                builder.setPositiveButton("确定",null);break;
        }
        builder.create().show();
    }
}
