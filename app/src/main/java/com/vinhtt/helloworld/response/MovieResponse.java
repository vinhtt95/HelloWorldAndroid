package com.vinhtt.helloworld.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vinhtt.helloworld.models.MovieModel;

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
