package com.pikpok.hrc.data.dfd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntityDataMob")
public class EntityDataMob {

    @ColumnInfo(name = "gaid")
    String gaid;
    @ColumnInfo(name = "appId")
    String appId;
    @ColumnInfo(name = "adb")
    String adb;
    @ColumnInfo(name = "bat")
    String bat;
    @PrimaryKey(autoGenerate = true)
    public  int id;

    public String getGaid() {
        return gaid;
    }

    public void setGaid(String gaid) {
        this.gaid = gaid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAdb() {
        return adb;
    }

    public void setAdb(String adb) {
        this.adb = adb;
    }

    public String getBat() {
        return bat;
    }

    public void setBat(String bat) {
        this.bat = bat;
    }
}
