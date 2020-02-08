package com.example.myapplication5;

import androidx.fragment.app.Fragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

//整体模块声明   执行忘网络请求操作
public class BaseFragment extends Fragment implements Callback.CommonCallback<String>{
    public void loadData(String path){
        RequestParams params=new RequestParams(path);
        x.http().get(params,this);
    }
//获取成功，回调接口
    @Override
    public void onSuccess(String result) {

    }
//失败接口
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }
//取消请求时的接口
    @Override
    public void onCancelled(CancelledException cex) {

    }
//请求完成的接口
    @Override
    public void onFinished() {

    }
}
