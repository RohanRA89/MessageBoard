package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rohanayub on 2/27/17.
 */
@Entity
public class Permissions {
    public static final String KEY_PERM_CREATE_THREAD = "PERM_CREATE_THREAD";
    public static final String KEY_PERM_EDIT_USR = "PERM_EDIT_USR";
    public static final String KEY_PERM_EDIT_POST = "PERM_EDIT_POST";
    public static final String KEY_PERM_DELETE_POST = "PERM_DELETE_POST";



    @Id @GeneratedValue
    private long id;
    private String key;
    private String permissionName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }




}
