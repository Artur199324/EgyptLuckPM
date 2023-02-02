package com.pikpok.hrc.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntityGol")
public class EntityGol {

    @ColumnInfo(name = "goo")
    public String goo;

    @PrimaryKey(autoGenerate = true)
    public int id;

    public EntityGol(String goo) {
        this.goo = goo;
    }
}
