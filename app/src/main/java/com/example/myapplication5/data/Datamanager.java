package com.example.myapplication5.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Datamanager {
    public  static SQLiteDatabase database;

    //初始化数据库信息
    public static  void intiDB(Context context){
        DatabaseH databaseH = new DatabaseH(context);
        database=databaseH.getWritableDatabase();
    }
    //查找数据库当中城市列表
    public  static List<String>queryAllCityName(){
        Cursor cursor = database.query("info",null,null,null,null,null,null);
        List<String>cityList=new ArrayList<>();
        while(cursor.moveToNext()){
            String city = cursor.getString(cursor.getColumnIndex("city"));
            cityList.add(city);
        }
        return  cityList;
    }
    //根据城市名称替换信息内容
    public static  int updateInfoByCity(String city,String content){
        ContentValues contentValues = new ContentValues();
        contentValues.put("content",content);
        return  database.update("info",contentValues,"city=?",new String[]{city});

    }
    //新增一条城市记录
    public  static  long addCityInfo(String city,String content){
        ContentValues contentValues = new ContentValues();
        contentValues.put("city",city);
        contentValues.put("content",content);
        return database.insert("info",null,contentValues);
    }
    //根据城市名查询数据库当中的内容
    public  static  String queryInfoByCity(String city){
        Cursor cursor = database.query("info", null, "city=?", new String[]{city}, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String content=cursor.getString(cursor.getColumnIndex("content"));
            return  content;
        }
        return null;

    }
    //最多5个，超过5个就不能存储，获取目前数量
    public static int getCitycount(){
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        int count=cursor.getCount();
        return count;

    }
    //查询数据库中的全部信息
    public static List<Databasebean>queryALLInfo(){
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        List<Databasebean>list=new ArrayList<>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("_Id"));
            String city = cursor.getString(cursor.getColumnIndex("city"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            Databasebean bean = new Databasebean(id, city, content);
            list.add(bean);

        }
        return  list;
    }
    public static void deleteAllInfo() {
    }

    public static int deleteInfoByCity(String city) {
        return 0;
    }
}
