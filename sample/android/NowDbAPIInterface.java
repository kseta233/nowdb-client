package com.eworkbandung.nowdb.example.service;

import com.eworkbandung.nowdb.example.model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Seta on 9/3/16.
 */

public interface NowDbAPIInterface {

    //GET : io.nowdb.net/v2/select_all/token/538d67698d909eca7dfb20a3/project/testnowdb/collection/todo/appid/57ca510c1f6d04fe523f718a
    @GET("select_all/token/{token}/project/{project}/collection/{collection}/appid/{appid}")
    Call<List<Todo>> getAllTodo(
            @Path("token") String token,
            @Path("project") String project,
            @Path("collection") String collection,
            @Path("appid") String appid
    );


    //GET : io.nowdb.net/v2/select_id/token/538d67698d909eca7dfb20a3/project/testnowdb/collection/todo/appid/57ca510c1f6d04fe523f718a/id/57ca5acc1f6d04fd523f7199
    @GET("select_id/token/{token}/project/{project}/collection/{collection}/appid/{appid}/id/{id}")
    Call<List<Todo>> getTodo(
            @Path("token") String token,
            @Path("project") String project,
            @Path("collection") String collection,
            @Path("appid") String appid,
            @Path("id") String id
    );

    //POST : io.nowdb.net/v2/insert
    @POST("insert")
    Call<Todo> inserTodo(
            @Field("token") String token,
            @Field("project") String project,
            @Field("collection") String collection,
            @Field("appid") String appid,

            @Field("action") String action,
            @Field("time") long milis,
            @Field("mark") boolean mark
    );


    //DELETE : io.nowdb.net/v2/remove_id/token/538d67698d909eca7dfb20a3/project/testnowdb/collection/todo/appid/57ca510c1f6d04fe523f718a/id/57ca5acc1f6d04fd523f7199
    @DELETE("remove_id/token/{token}/project/{project}/collection/{collection}/appid/{appid}/id/{id}")
    Call<Response> deleteTodo(
            @Path("token") String token,
            @Path("project") String project,
            @Path("collection") String collection,
            @Path("appid") String appid,
            @Path("id") String id
    );


    //PUT : io.nowdb.net/v2/update_id/token/538d67698d909eca7dfb20a3/project/testnowdb/collection/todo/appid/57ca510c1f6d04fe523f718a/id/57ca5acc1f6d04fd523f7199
    @PUT("update_id/token/{token}/project/{project}/collection/{collection}/appid/{appid}/id/{id}")
    Call<Response> updateTodo(
            @Path("token") String token,
            @Path("project") String project,
            @Path("collection") String collection,
            @Path("appid") String appid,
            @Path("id") String id,

            @Field("action") String action,
            @Field("time") long milis,
            @Field("mark") boolean mark
    );
}
//}
//public class NowDbService {
//
//
////
////    private NowDBAPIInterface mApi;
////
////    public NowDbService(RestClient restClient) {
////        mApi = restClient.create(NowDBAPIInterface.class);
////    }
////
////    //implement
////    public void getAllTodo (){
////        Call<List<Todo>> listCall = mApi.getAllTodo(
////                RestAPI.NOWDB_TOKEN,
////                RestAPI.NOWDB_PROJECT,
////                RestAPI.Collection.TODO,
////                RestAPI.NOWDB_APPID
////        );
////        listCall.enqueue(
////                new Callback<List<Todo>>() {
////                    @Override
////                    public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
////                        System.out.println(response.body().toString());
////                    }
////
////                    @Override
////                    public void onFailure(Call<List<Todo>> call, Throwable t) {
////
////                    }
////                }
////        );
////    }
//
//
//}
