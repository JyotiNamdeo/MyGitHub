package com.example.rtwm38.mygithub.servies;

import com.example.rtwm38.mygithub.model.PullRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubUserInfo {
    @GET("/repos/{name}/github-app-example/pulls")
    Call<List<PullRequest>> getPullRequests(@Path("name") String userName, @Query("page") int page, @Query("access_token") String accessToken);
}
