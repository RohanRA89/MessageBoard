package com.ironyard.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rohanayub on 2/9/17.
 */
@Entity
public class Thread {
    @Id
    @GeneratedValue
    private long id;
    private String threadName;
    private String threadDescription;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadDescription() {
        return threadDescription;
    }

    public void setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
    }



}
