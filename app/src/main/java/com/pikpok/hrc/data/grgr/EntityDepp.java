package com.pikpok.hrc.data.grgr;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntityDepp")
public class EntityDepp {

    @ColumnInfo(name = "deep")
    String deep;

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String getDeep() {
        return deep;
    }

    public void setDeep(String deep) {
        this.deep = deep;
    }
}
