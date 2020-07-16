package ua.vitamin.friendsjava.people;

import android.content.Context;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.vitamin.friendsjava.api.RandomUserAPI;
import ua.vitamin.friendsjava.dto.Result;
import ua.vitamin.friendsjava.dto.UserDTO;

public class MainActivityModel implements Callback<UserDTO> {
    private final String BASE_URL = "https://randomuser.me/";

    private Retrofit retrofit;
    private Gson gson;
    private Call<UserDTO> call;
    private RandomUserAPI api;
    private RecyclerView recyclerView;
    private Context context;

    public MainActivityModel () {}

    public MainActivityModel (RecyclerView recyclerView, Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
    }

    public void onStart() {

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();

        api = retrofit.create(RandomUserAPI.class);

        call = api.getPeople();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<UserDTO> call, Response<UserDTO> response) {
        List<Result> resultList = response.body().getResults();

        recyclerView.setAdapter(new PeopleRecyclerViewAdapter(resultList, context));
    }

    @Override
    public void onFailure(Call<UserDTO> call, Throwable t) {
        t.printStackTrace();
        Log.d("user_dto", t.getLocalizedMessage());
    }
}
