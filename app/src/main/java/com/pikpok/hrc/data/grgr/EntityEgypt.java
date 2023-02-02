package com.pikpok.hrc.data.grgr;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntityEgypt")
public class EntityEgypt {

    @ColumnInfo(name = "egypt")
    public String egypt;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public EntityEgypt(String egypt) {
        this.egypt = egypt;
    }
}
