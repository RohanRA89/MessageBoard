package com.ironyard.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rohanayub on 2/17/17.
 */
public class FromForm {

    private long id;
    private String name;
    private String displayName;
    private String password;
    private MultipartFile profileImageFile;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getProfileImage() {
        return profileImageFile;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImageFile = profileImage;
    }

}
