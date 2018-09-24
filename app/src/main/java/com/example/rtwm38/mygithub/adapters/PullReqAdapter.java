package com.example.rtwm38.mygithub.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rtwm38.mygithub.R;
import com.example.rtwm38.mygithub.model.PullRequest;
import com.example.rtwm38.mygithub.ui.PRDiffActivity;

import java.util.List;

public class PullReqAdapter extends RecyclerView.Adapter<PullReqAdapter.PullReqViewHolder> {
    List<PullRequest> prs;
    Context mContext;

    public PullReqAdapter(List<PullRequest> prs, Context context) {
        this.mContext = context;
        this.prs = prs;
    }


    @NonNull
    @Override
    public PullReqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("PullReqAdapter bind", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pull_req_item, null);
        PullReqViewHolder viewHolder = new PullReqViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PullReqViewHolder holder, int position) {
        Log.d("PullReqAdapter bind", prs.get(position).getTitle());
        PullRequest feedItem = prs.get(position);
        holder.title.setText(feedItem.getTitle());
        if (holder.review_comment != null)
           // holder.review_comment.setText(feedItem.getReview_comment());
        if (holder.created_at != null)
            holder.created_at.setText("Opened on "+feedItem.getCreated_at());
        if (holder.login != null)
         //   holder.login.setText(" by "+feedItem.getLogin());

        holder.html_url = prs.get(position).getHtml_url();
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PRDiffActivity.class);
                intent.putExtra("html_url", holder.html_url);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return prs.size();
    }

    class PullReqViewHolder extends RecyclerView.ViewHolder {
        protected TextView title;
        protected TextView review_comment;
        protected TextView created_at;;
        protected TextView login;
        protected String html_url;

        public PullReqViewHolder(View view) {
            super(view);
            this.title = view.findViewById(R.id.title);
            this.review_comment = view.findViewById(R.id.review_comment);
            this.created_at = view.findViewById(R.id.created_at);
            this.login = view.findViewById(R.id.login);
        }
    }
}
