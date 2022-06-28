package com.vinhtt.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vinhtt.helloworld.adapters.MovieRecyclerView;
import com.vinhtt.helloworld.adapters.OnMovieListener;
import com.vinhtt.helloworld.models.MovieModel;
import com.vinhtt.helloworld.request.Servicey;
import com.vinhtt.helloworld.response.MovieSearchResponse;
import com.vinhtt.helloworld.utils.Credentials;
import com.vinhtt.helloworld.utils.MovieAPI;
import com.vinhtt.helloworld.viewmodels.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity implements OnMovieListener {

    private RecyclerView recyclerView;
    private MovieRecyclerView movieRecyclerAdapter;

    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        ConfigureRecyclerView();
        //Calling the obs
        ObserveAnyChange();

        searchMovieApi("fast", 1);
    }

    //Observing any data change
    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // Observing for any data change
                if (movieModels != null) {
                    for (MovieModel movieModel : movieModels) {
                        Log.v("Tag", "Title: " + movieModel.getTitle());
                        movieRecyclerAdapter.setmMovies(movieModels);
                    }
                }
            }
        });
    }

    private void searchMovieApi(String query, int pageNumber) {
        movieListViewModel.seachMovieApi(query,pageNumber);
    }

    private void ConfigureRecyclerView(){
        movieRecyclerAdapter = new MovieRecyclerView(this);

        recyclerView.setAdapter(movieRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onMovieClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {

    }

//    private void GetRetrofitResponse() {
//        MovieAPI movieAPI = Servicey.getMovieAPI();
//
//        Call<MovieSearchResponse> responseCall = movieAPI.searchMovie(
//                Credentials.API_KEY,
//                "Jack Reacher",
//                1
//        );
//
//        responseCall.enqueue(new Callback<MovieSearchResponse>() {
//            @Override
//            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                if (response.code() == 200) {
//                    Log.v("Tag", "The response" + response.body().toString());
//
//                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//
//                    for(MovieModel movie:movies){
//                        Log.v("Tag", "The list" + movie.getRelease_date());
//                    }
//                }else{
//                    try{
//                        Log.v("Tag", "Error" + response.errorBody().toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//
//            }
//        });
//    }
//    private void GetRetrofitResponseAccordingToID() {
//        MovieAPI movieAPI = Servicey.getMovieAPI();
//
//        Call<MovieModel> responseCall = movieAPI.getMovie(550, Credentials.API_KEY
//        );
//
//        responseCall.enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                if (response.code() == 200) {
//
//                    MovieModel movie = response.body();
//                    Log.v("Tag", "The Response " + movie.toString());
//
//                }else{
//                    try{
//                        Log.v("Tag", "Error" + response.errorBody().toString());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//
//            }
//        });
//    }
}