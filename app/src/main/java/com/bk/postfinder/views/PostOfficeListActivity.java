package com.bk.postfinder.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bk.androidlocation.R;
import com.bk.postfinder.adapters.RecyclerAdapter;
import com.bk.postfinder.models.PostOfficeModel;
import com.bk.postfinder.services.ApiClient;
import com.bk.postfinder.services.PostOfficeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostOfficeListActivity extends AppCompatActivity {

    private static final String TAG = "PostOfficeListActivity";

    List<PostOfficeModel> postOfficeModelList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_office_list);
        Log.d(TAG, "onCreate: started");

        postOfficeModelList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view_postOffices_list);

        recyclerAdapter = new RecyclerAdapter(this, postOfficeModelList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        PostOfficeService postOfficeService = ApiClient.getClientInstance().create(PostOfficeService.class);

        Call<List<PostOfficeModel>> call = postOfficeService.getPostOffices();

        Log.d(TAG, "-----URL----- : "+call.request().url());

        call.enqueue(new Callback<List<PostOfficeModel>>() {
            @Override
            public void onResponse(Call<List<PostOfficeModel>> call, Response<List<PostOfficeModel>> response) {
                postOfficeModelList = response.body();

                recyclerAdapter = new RecyclerAdapter(getApplicationContext(), postOfficeModelList);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onFailure(Call<List<PostOfficeModel>> call, Throwable t) {
                Log.d(TAG, "-----FAIL----- : " + t.getMessage());
            }
        });
    }

}
