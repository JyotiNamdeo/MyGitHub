package com.example.rtwm38.mygithub.model;

import java.util.List;

public class PullRequest {
    String title ;
    String html_url ;

    String created_at;
    String state;
    String number;
    public List <User> user;


    public List getUser() {
        return user;
    }

    public void setUser(List user) {
        this.user = user;
    }
    /*    String full_name;
    String label;
    String label;
    String _links;
    String review_comment;*/

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

/*    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public String get_links() {
        return _links;
    }

    public void set_links(String _links) {
        this._links = _links;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
    }*/

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
