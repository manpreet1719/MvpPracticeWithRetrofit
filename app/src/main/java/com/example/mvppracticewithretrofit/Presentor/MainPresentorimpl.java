package com.example.mvppracticewithretrofit.Presentor;

import android.view.MenuItem;

import com.example.mvppracticewithretrofit.Model.Todo;
import com.example.mvppracticewithretrofit.R;

import java.util.ArrayList;
import java.util.List;

public class MainPresentorimpl implements MainContract.presenter , MainContract.GetTodoList.OnFinishedListener{

 private MainContract.MainView mainView;
 private MainContract.GetTodoList getTodoList;

    public MainPresentorimpl(MainContract.MainView mainView, MainContract.GetTodoList getTodoList) {
        this.mainView = mainView;
        this.getTodoList = getTodoList;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }


    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getTodoList.getTodoArrayList(this);

    }
    @Override
    public void requestDataFromServer() {
        getTodoList.getTodoArrayList(this);
    }

    @Override
    public void setdata(Todo todo) {

        getTodoList.settingdata(todo);
    }


    @Override
    public void onFinished(List<Todo> noticeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }






}
