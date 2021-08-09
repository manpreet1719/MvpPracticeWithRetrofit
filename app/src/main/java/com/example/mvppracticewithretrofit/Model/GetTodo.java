package com.example.mvppracticewithretrofit.Model;

import android.util.Log;

import com.example.mvppracticewithretrofit.Presentor.MainContract;
import com.example.mvppracticewithretrofit.api.ApiClient;
import com.example.mvppracticewithretrofit.api.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetTodo implements MainContract.GetTodoList {

    ApiInterface apiInterface;
    private static final String TAG = "GetTodo";

    @Override
    public void settingdata(Todo todo) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Todo> todoPostCall = apiInterface.postTodo(todo);
        todoPostCall.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                Log.e(TAG, "onResponse:32322 " + response.body() );
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }
        });

    }

    @Override
    public void getTodoArrayList(final OnFinishedListener onFinishedListener) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Todo>> call = apiInterface.getTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                Log.e(TAG, "onResponse: " +  response.body());
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }




}
