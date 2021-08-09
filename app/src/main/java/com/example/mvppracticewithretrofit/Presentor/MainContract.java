package com.example.mvppracticewithretrofit.Presentor;

import com.example.mvppracticewithretrofit.Model.Todo;

import java.util.ArrayList;
import java.util.List;

public interface MainContract {

    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

        void setdata(Todo todo);
    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Todo> TodoArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetTodoList {

        void settingdata(Todo todo);

        interface OnFinishedListener {
            void onFinished(List<Todo> TodoArrayList);
            void onFailure(Throwable t);
        }

        void getTodoArrayList(OnFinishedListener onFinishedListener);
    }

}
