package com.example.rtwm38.mygithub.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.rtwm38.mygithub.R;
import com.example.rtwm38.mygithub.adapters.PullReqAdapter;
import com.example.rtwm38.mygithub.model.PullRequest;
import com.example.rtwm38.mygithub.servies.GitHubUserInfo;
import com.example.rtwm38.mygithub.servies.RetrofitInstance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPullRequestActivity extends Activity{
    private RecyclerView mPRRecyclerView;
    private String userName = "bkeepers";
    private String userToken = "";
    private String TAG = this.getClass().getSimpleName();
    private PullReqAdapter mPRAdapter;
    private TextView mAuthorTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPRRecyclerView = findViewById(R.id.prRecyclerView);
        mAuthorTextView = findViewById(R.id.authorTextView);
        loadRepowithPRs();
    }
    private void loadRepowithPRs() {
        GitHubUserInfo prService = RetrofitInstance.getRetrofitInstance().create(GitHubUserInfo.class);
        Call<List<PullRequest>> call = prService.getPullRequests(userName, 1, userToken);
        call.enqueue(new Callback<List<PullRequest>>() {
            @Override
            public void onResponse(Call<List<PullRequest>> call, Response<List<PullRequest>> response) {
                if (response != null) {
                    Iterator<PullRequest> iterator = response.body().listIterator();
                    List<PullRequest> list = new ArrayList<>();
                    while (iterator.hasNext()) {
                        PullRequest pr = iterator.next();
                        list.add(pr);
                    }

                    Log.d(TAG, "NamdeoNamdeo user "+list.get(0).getUser().get(0));
                   // Log.d(TAG, "NamdeoNamdeo links "+list.get(0).get_links());
                    //Log.d(TAG, "NamdeoNamdeo reiview  comments "+list.get(0).getReview_comment());
                   // Log.d(TAG, "NamdeoNamdeo login "+list.get(0).getLogin());
                   // Log.d(TAG, "NamdeoNamdeo number "+list.get(0).getNumber());
                    //label- null, login-null, link fail, full name

                    mPRAdapter = new PullReqAdapter(list, getApplicationContext());
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mPRRecyclerView.setLayoutManager(mLayoutManager);
                    mPRRecyclerView.setItemAnimator(new DefaultItemAnimator());
                    mPRRecyclerView.setAdapter(mPRAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<PullRequest>> call, Throwable t) {
                Log.d(TAG, "Failed to get PRs "+t.toString());
            }
        });
    }
}
