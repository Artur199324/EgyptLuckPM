package com.pikpok.hrc.startEgypt.rfrfr;

import static com.facebook.applinks.AppLinkData.fetchDeferredAppLinkData;
import static com.pikpok.hrc.Application.fFd;
import static com.pikpok.hrc.Application.userDao;

import android.annotation.SuppressLint;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.pikpok.hrc.data.grgr.EntityDepp;
import com.pikpok.hrc.startEgypt.StartEgypt;
import com.pikpok.hrc.ui.SplashActivity;

import java.net.URLEncoder;
import java.util.Objects;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FbEgypt {

    private final SplashActivity splashActivity;
    private final StartEgypt startEgypt;

    public FbEgypt(SplashActivity splashActivity, StartEgypt startEgypt) {
        this.splashActivity = splashActivity;
        this.startEgypt = startEgypt;
        init();
    }

    private void init(){
        FacebookSdk.setApplicationId(startEgypt.ffffId);
        FacebookSdk.setClientToken(startEgypt.ffffftok);
        FacebookSdk.sdkInitialize(splashActivity);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
    }

    public void getFb(){
        EntityDepp entityDepp = new EntityDepp();
        fetchDeferredAppLinkData(splashActivity, appLinkData -> {
            try {
                if (appLinkData == null){
                    appLinkData = AppLinkData.createFromActivity(splashActivity);
                    entityDepp.setDeep(fFd.getNnn());
                    saveDip(entityDepp);
                }

            }catch (Exception e){
                entityDepp.setDeep(fFd.getNnn());
                saveDip(entityDepp);
            }

            try {
               if (appLinkData != null){
                   entityDepp.setDeep(URLEncoder.encode(Objects.requireNonNull(appLinkData.getTargetUri()).toString(),fFd.getUtf()));
                   saveDip(entityDepp);
               }
            }catch (Exception e){
                entityDepp.setDeep(fFd.getNnn());
                saveDip(entityDepp);
            }
        });
    }

    @SuppressLint("CheckResult")
    private void saveDip(EntityDepp entityDepp){
        Completable.fromAction(() -> userDao.insertDeep(entityDepp))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.d("www","dddd"),
                        throwable -> Log.e("wwww",throwable.getMessage()));
    }
}
