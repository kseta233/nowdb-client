package com.eworkbandung.nowdb.example.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eworkbandung.nowdb.example.R;
import com.eworkbandung.nowdb.example.constant.RestAPI;
import com.eworkbandung.nowdb.example.model.Todo;
import com.eworkbandung.nowdb.example.service.NowDbAPIInterface;


import java.util.List;

import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private Retrofit retrofit;
    private ProgressDialog progressDialog;

    Button btn;
    TextView tv;

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initializeRetrofit();
        btn = (Button) findViewById(R.id.myButton);
        tv = (TextView) findViewById(R.id.myTextView);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataAsJSON();
                    }
                }
        );
    }

    /**
     * method to initialize retrofit in current activity
     */
    private void initializeRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);  // <-- for loggin purpose

         retrofit = new Retrofit.Builder()
                .baseUrl(RestAPI.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }

    public void postData(String action, long milis,boolean mark){
        //call interface
        NowDbAPIInterface apiService = retrofit.create(NowDbAPIInterface.class);
        //implement method
        Call<Todo> result = apiService.inserTodo(
                RestAPI.NOWDB_TOKEN,
                RestAPI.NOWDB_PROJECT,
                RestAPI.Collection.TODO,
                RestAPI.NOWDB_APPID,

                action,
                milis,
                mark
        );
        //get result callback
        result.enqueue(
                new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {

                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable t) {

                    }
                }
        );
    }

    public void updateData(String id, String action, long milis,boolean mark){
        //call interface
        NowDbAPIInterface apiService = retrofit.create(NowDbAPIInterface.class);
        //implement method
        Call<Response> result = apiService.updateTodo(
                RestAPI.NOWDB_TOKEN,
                RestAPI.NOWDB_PROJECT,
                RestAPI.Collection.TODO,
                RestAPI.NOWDB_APPID,
                id,
                action,
                milis,
                mark
        );
        //get result callback
//        result.enqueue(...);
    }
    public void getDataAsJSON(){

        NowDbAPIInterface apiService = retrofit.create(NowDbAPIInterface.class);
        //success
//        Call<List<Todo>> result = apiService.getAllTodo(
//                RestAPI.NOWDB_TOKEN,
//                RestAPI.NOWDB_PROJECT,
//                RestAPI.Collection.TODO,
//                RestAPI.NOWDB_APPID
//        );
//        result.enqueue(new Callback<List<Todo>>() {
//            @Override
//            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
////                Log.d(TAG, "response to do" + response.toString());
//                List<Todo> listTodo = response.body();
//                String tmp = "";
//                for (Todo item : listTodo) {
//                    tmp += item.toString() + "\n";
//                }
//                tv.setText(tmp);
//            }
//
//            @Override
//            public void onFailure(Call<List<Todo>> call, Throwable t) {
//                t.printStackTrace();
//                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        Call<List<Todo>> result = apiService.getTodo (
                RestAPI.NOWDB_TOKEN,
                RestAPI.NOWDB_PROJECT,
                RestAPI.Collection.TODO,
                RestAPI.NOWDB_APPID,
                RestAPI.DUMMY_ID
        );

        result.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
//                Log.d(TAG, "response to do" + response.toString());
                List<Todo> listTodo = response.body();
                System.out.println(listTodo.get(0));
                String tmp = "";
                for (Todo item : listTodo) {
                    tmp += item.toString() + "\n";
                }
                tv.setText(tmp);
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//
//    @OnClick(R.id.myButton)
//    public void buttonAction() {
//        System.out.println("im pressed");
//        Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
//        this.getDataAsJSON();
//    }
}
