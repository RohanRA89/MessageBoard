package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rohanayub on 2/9/17.
 */
@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String postContent;
    private String timeOfPost;
    private String usernameOfPoster;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getTimeOfPost() {
        return timeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        this.timeOfPost = timeOfPost;
    }

    public String getUsernameOfPoster() {
        return usernameOfPoster;
    }

    public void setUsernameOfPoster(String usernameOfPoster) {
        this.usernameOfPoster = usernameOfPoster;
    }


}
