package com.example.tugas8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConcertFragment extends Fragment {
    String api_key = "d084aa285ae24879b93afaa17a1ccdff";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="id";
    private RecyclerView recyclerViewsconcert;
    private String category="kpop concert";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.concertfragment,null);
        recyclerViewsconcert=v.findViewById(R.id.recyclerconcert);
        modelClassArrayList = new ArrayList<>();
        recyclerViewsconcert.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewsconcert.setAdapter(adapter);
        findNews();
        return v;
    }
    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api_key)
                .enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {
            }
        });
    }
}