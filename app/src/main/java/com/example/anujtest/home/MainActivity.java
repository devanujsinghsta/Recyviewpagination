package com.example.anujtest.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.anujtest.R;
import com.example.anujtest.networkingCalling.ApiData;
import com.example.anujtest.networkingCalling.ApiInteface;
import com.example.anujtest.networkingCalling.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.anujtest.utils.UtilFunction.dismiss;
import static com.example.anujtest.utils.UtilFunction.show;

public class MainActivity extends AppCompatActivity {
    private ApiInteface apiInteface;
    private RecyclerView recyclerView_list;
    private List<ModelData.Datum> listdata = new ArrayList<>();
    HomeAdpatre homeAdpatre;
    int position = 1;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    private LinearLayoutManager linearLayoutManager;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_list = findViewById(R.id.recyview_list);


        if (position == 1) {
            onClickApiCalling(position);

        }
        recyclerView_list.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView_list.setLayoutManager(linearLayoutManager);
        homeAdpatre = new HomeAdpatre(listdata, this);
        recyclerView_list.setAdapter(homeAdpatre);

        recyclerView_list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            Log.v("...", "Last Item Wow !");
                            position = position + 1;
                            Log.d(TAG, "onScrolled: " + position);
                            onClickApiCalling(position);

                        }
                    }
                }
            }
        });
    }

    private void onClickApiCalling(int pageNumber) {
        Log.d(TAG, "onClickApiCalling: " + pageNumber);
        show(MainActivity.this, "Loading....");
        apiInteface = ApiData.getRetrofit().create(ApiInteface.class);
        Call<ModelData> callapi_listing = apiInteface.getdata("article_users?page=" + pageNumber);
        Log.e(TAG, "onClickApiCalling: " + callapi_listing.request().url());
        callapi_listing.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                if (response.isSuccessful()) {
                    dismiss(MainActivity.this);

                    if (response.body().getData() != null && response.body().getData().size() == 0) {
                        Toast.makeText(MainActivity.this, "No data Avalible hare.", Toast.LENGTH_SHORT).show();
                    } else {
                        listdata.addAll(response.body().getData());
                        homeAdpatre.notifyDataSetChanged();
                        loading = true;
                    }


                }
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
                dismiss(MainActivity.this);


            }
        });


    }


}