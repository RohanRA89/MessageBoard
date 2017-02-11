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
}
