package com.vinhtt.helloworld.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.vinhtt.helloworld.models.MovieModel;
import com.vinhtt.helloworld.repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    private MovieRepository movieRepository;

    public MovieListViewModel() {
        movieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieRepository.getMovies();
    }

    //Calling method in view-model
    public void seachMovieApi(String query, int pageNumber) {
        movieRepository.searchMovieApi(query, pageNumber);
    }
}
