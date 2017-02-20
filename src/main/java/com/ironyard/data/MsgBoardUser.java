package com.ironyard.data;

import com.ironyard.dto.FromForm;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rohanayub on 2/9/17.
 */
@Entity
public class MsgBoardUser {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String displayName;
    private String password;
    private String profileFileName;

    public MsgBoardUser(){

    }

//    public MsgBoardUser(FromForm dataFromForm, String profileFileName){
//        this.id = dataFromForm.getId();
//        this.name = dataFromForm.getName();
//        this.displayName = dataFromForm.getDisplayName();
//        this.password = dataFromForm.getPassword();
//        this.profileFileName = profileFileName;
//    }
//
//    public MsgBoardUser(FromForm dataFromForm){
//        this.id = dataFromForm.getId();
//        this.name = dataFromForm.getName();
//        this.displayName = dataFromForm.getDisplayName();
//        this.password = dataFromForm.getPassword();
//    }


    public String getProfileFileName() {
        return profileFileName;
    }

    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }

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


}
