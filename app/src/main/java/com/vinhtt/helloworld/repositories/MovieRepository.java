package com.vinhtt.helloworld.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vinhtt.helloworld.models.MovieModel;
import com.vinhtt.helloworld.request.MovieApiClient;

import java.util.List;

public class MovieRepository {

    private static MovieRepository instance;

    private MovieApiClient movieApiClient;

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository(){
        movieApiClient = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieApiClient.getMovies();
    }

    //Calling the method in repository
    public void searchMovieApi(String query, int pageNumber) {
        movieApiClient.searchMoviesApi(query, pageNumber);
    }
}

