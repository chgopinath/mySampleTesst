package com.drivetests.androidtask2.screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.drivetests.androidtask2.R;
import com.drivetests.androidtask2.adapter.TitleAdapter;
import com.drivetests.androidtask2.api_calling.ApiClient;
import com.drivetests.androidtask2.api_interface.ApiInterface;
import com.drivetests.androidtask2.click_listener.Counter;
import com.drivetests.androidtask2.model.ListModel;
import com.drivetests.androidtask2.model.ObjectModel;
import com.drivetests.androidtask2.scroll_listener.EndlessRecyclerOnScrollListener;
import com.drivetests.androidtask2.scroll_listener.HidingScrollListener;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv_list;
    Toolbar my_toolbar;

    ArrayList<ObjectModel>  listModelArrayList;
    ArrayList<Integer> countList;
    TitleAdapter titleAdapter;
    private Counter counter;
    LinearLayoutManager linearLayoutManager;
    int count = 1;
    private boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    int firstVisibleItem;
    private int visibleThreshold = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_toolbar = findViewById(R.id.my_toolbar);
        my_toolbar.setTitle("Android Task");
        my_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(my_toolbar);
        rv_list = findViewById(R.id.rv_list);
        linearLayoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(linearLayoutManager);

        listModelArrayList = new ArrayList<>();
        countList = new ArrayList<>();



        //Toolbar count
       getToolbarCount();



       // API Calling
        getApiCall(""+count);

        //RecyclerView Auto Scroll loading
        rv_list.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.i("Yaeye!", "end called");
                            count = count+1;
                            getApiCall(""+count);
                            Toast.makeText(MainActivity.this,"current_page: "+count,Toast.LENGTH_SHORT).show();
                            loading = true;

                        }
                    }

                }
            }
        });

    }


    // API Calling
    private void  getApiCall(String count){

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ListModel> call = apiService.getListData(count);
        call.enqueue(new Callback<ListModel>() {
            @Override
            public void onResponse(Call<ListModel>call, Response<ListModel> response) {

                if(response.body() != null){
                    ListModel dataObject = response.body();
                    if(dataObject != null){
                        listModelArrayList.clear();
                        if(dataObject.getHits() != null){
                            listModelArrayList = dataObject.getHits();
                            if(listModelArrayList.size() > 0){
                                titleAdapter = new TitleAdapter(MainActivity.this,listModelArrayList,countList,counter);
                                rv_list.setAdapter(titleAdapter);
                                titleAdapter.notifyDataSetChanged();
                            }

                            Log.d("dd0",""+countList.size());
                        }

                    }

                }else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ListModel>call, Throwable t) {
                // Log error here since request failed
                Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Toolbar Count

    private void getToolbarCount(){

        counter = new Counter() {
            @Override
            public void setCounter(int count) {
                Log.e("Ser_Counter", "" + count);
                my_toolbar.setTitle("Checked Count:"+count);
            }
        };

    }
}
