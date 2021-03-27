package com.example.anujtest.home;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anujtest.R;
import com.example.anujtest.databinding.ActivityMainBinding;
import com.example.anujtest.networkingCalling.ApiData;
import com.example.anujtest.networkingCalling.ApiInteface;
import com.example.anujtest.networkingCalling.ModelData;
import com.example.anujtest.utils.ConnectionDetector;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.anujtest.utils.UtilFunction.dismiss;
import static com.example.anujtest.utils.UtilFunction.noInternetConnection;
import static com.example.anujtest.utils.UtilFunction.show;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ApiInteface mApiInteface;
    private RecyclerView mRecyclerViewList;
    private List<ModelData.Datum> mListViewData = new ArrayList<>();
    private HomeAdpatre mHomeAdapater;
    private int position = 1;
    private boolean loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setOnRecyclview(activityMainBinding);

        if (position == 1) {
            if (ConnectionDetector.isNetworkAvailable(this)) {
                onClickApiCalling(position);
            } else {
                noInternetConnection(this);
            }
        }

        mRecyclerViewList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                            position = position + 1;
                            onClickApiCalling(position);

                        }
                    }
                }
            }
        });
    }

    private void setOnRecyclview(ActivityMainBinding activityMainBinding) {
        mRecyclerViewList = activityMainBinding.recyviewList;
        mRecyclerViewList.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerViewList.setLayoutManager(linearLayoutManager);
        mHomeAdapater = new HomeAdpatre(mListViewData, this);
        mRecyclerViewList.setAdapter(mHomeAdapater);
    }

    private void onClickApiCalling(int pageNumber) {
        show(MainActivity.this, "Loading....");
        mApiInteface = ApiData.getRetrofit().create(ApiInteface.class);
        Call<ModelData> callapi_listing = mApiInteface.getdata("article_users?page=" + pageNumber);
        //  Log.e(TAG, "onClickApiCalling: " + callapi_listing.request().url());
        callapi_listing.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                if (response.isSuccessful()) {
                    dismiss(MainActivity.this);
                    if (response.body().getData() != null && response.body().getData().size() == 0) {
                        Toast.makeText(MainActivity.this, "No data Avalible hare.", Toast.LENGTH_SHORT).show();
                    } else {
                        assert response.body().getData() != null;
                        mListViewData.addAll(response.body().getData());
                        mHomeAdapater.notifyDataSetChanged();
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