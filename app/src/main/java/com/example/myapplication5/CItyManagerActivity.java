package com.example.myapplication5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication5.data.Databasebean;
import com.example.myapplication5.data.Datamanager;

import java.util.ArrayList;
import java.util.List;

public class CItyManagerActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView addIv,backIv,deleteIv;
    ListView cityLv;
    List<Databasebean>mDatas;//显示列表数据源
    private cityManagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_city_manager);
        addIv=findViewById(R.id.city_iv_add);
        backIv=findViewById(R.id.city_iv_back);
        deleteIv=findViewById(R.id.city_iv_delete);
        cityLv=findViewById(R.id.city_lv);
        mDatas=new ArrayList<>();
        //添加监听
        addIv.setOnClickListener(this);
        deleteIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        //设置适配器
        adapter = new cityManagerAdapter(this, mDatas);
        cityLv.setAdapter(adapter);

    }
//获取数据库真实数据源，添加到原有数据当中，提示适配器更新
    @Override
    protected void onResume() {
        super.onResume();
        List<Databasebean> list = Datamanager.queryALLInfo();
        mDatas.clear();
        mDatas.addAll(list);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.city_iv_add:
                int citycount = Datamanager.getCitycount();
                if(citycount<5){
                Intent intent = new Intent(this, SearchCityActivity.class);
                startActivity(intent);}
                else {
                    Toast.makeText(this,"城市数量已达上限",Toast.LENGTH_SHORT).show();
                }
                break;
            case  R.id.city_iv_back:
                finish();
                break;
            case  R.id.city_iv_delete:
                Intent intent1 = new Intent(this, DeleteCityActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
