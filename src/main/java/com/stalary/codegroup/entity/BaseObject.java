package com.stalary.codegroup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseObject {

    public BaseObject() {
        this.latestTime = new Date();
    }

    public BaseObject(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;


    /**
     * 最后修改时间
     */
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    protected Date latestTime;


    public void setKeyId(Integer id) {
        this.id = id;
    }

    public Integer getKeyId() {
        return id;
    }

    public Date getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Date latestTime) {
        this.latestTime = latestTime;
    }
}
