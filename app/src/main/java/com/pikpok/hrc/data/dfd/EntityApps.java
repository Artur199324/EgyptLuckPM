package com.pikpok.hrc.data.dfd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "EntityApps")
public class EntityApps {
    @ColumnInfo(name ="afstatus" )
   public String af_status;
    @ColumnInfo(name = "afchannel")
    public String af_channel;
    @ColumnInfo(name = "mediasource")
    public String media_source;
    @ColumnInfo(name = "campaign")
    public String campaign;
    @ColumnInfo(name = "afad")
    public  String af_ad;
    @ColumnInfo(name = "campaignid")
    public String campaign_id;
    @ColumnInfo(name = "adsetid")
    public  String adset_id;
    @ColumnInfo(name = "adid")
    public String ad_id;
    @ColumnInfo(name = "adset")
    public  String adset;
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String getAf_status() {
        return af_status;
    }

    public void setAf_status(String af_status) {
        this.af_status = af_status;
    }

    public String getAf_channel() {
        return af_channel;
    }

    public void setAf_channel(String af_channel) {
        this.af_channel = af_channel;
    }

    public String getMedia_source() {
        return media_source;
    }

    public void setMedia_source(String media_source) {
        this.media_source = media_source;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getAf_ad() {
        return af_ad;
    }

    public void setAf_ad(String af_ad) {
        this.af_ad = af_ad;
    }

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getAdset_id() {
        return adset_id;
    }

    public void setAdset_id(String adset_id) {
        this.adset_id = adset_id;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getAdset() {
        return adset;
    }

    public void setAdset(String adset) {
        this.adset = adset;
    }
}
