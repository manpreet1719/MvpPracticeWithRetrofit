package com.example.mvppracticewithretrofit.api;

import com.example.mvppracticewithretrofit.Model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("todos")
    Call<List<Todo>> getTodos();


    @POST("/todos")
    Call<Todo> postTodo(@Body  Todo todo);




}
