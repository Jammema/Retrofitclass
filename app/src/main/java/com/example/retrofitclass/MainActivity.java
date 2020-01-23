package com.example.retrofitclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitclass.adapter.DesignAdapter;
import com.example.retrofitclass.interfaces.ApiInterface;
import com.example.retrofitclass.model.Design;
import com.example.retrofitclass.model.FacebookResponse;
import com.example.retrofitclass.model.FbFeed;
import com.example.retrofitclass.wepapi.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<Design> designs;
    private DesignAdapter designAdapter;

    private ApiInterface apiInterface;
    private List<FbFeed> feedList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofit().create(ApiInterface.class);

        getAllFacebookFeed();
        init();
        getAllProduct();
    }

    private void getAllFacebookFeed() {
        apiInterface.getFBResponse().enqueue(new Callback<FacebookResponse>() {
            @Override
            public void onResponse(Call<FacebookResponse> call, Response<FacebookResponse> response) {
                FacebookResponse facebookResponse = response.body();
                feedList = facebookResponse.getFbFeed();
                Toast.makeText(MainActivity.this, "" + feedList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<FacebookResponse> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerview = findViewById(R.id.recyclerview);
        designs = new ArrayList<>();
        designAdapter = new DesignAdapter(this, designs);
        recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerview.setAdapter(designAdapter);
    }

    private void getAllProduct() {
        designs.add(new Design(R.drawable.scenery, ""));
    }
}
