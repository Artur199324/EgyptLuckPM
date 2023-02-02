package com.pikpok.hrc.startEgypt.rfrfr;

import static com.pikpok.hrc.Application.appsStart;
import static com.pikpok.hrc.Application.fFd;
import static com.pikpok.hrc.Application.userDao;

import android.annotation.SuppressLint;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.pikpok.hrc.data.dfd.EntityApps;
import com.pikpok.hrc.startEgypt.StartEgypt;
import com.pikpok.hrc.ui.SplashActivity;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AppsEgypt {
    private final SplashActivity splashActivity;
    private final StartEgypt startEgypt;

    public AppsEgypt(SplashActivity splashActivity, StartEgypt startEgypt) {
        this.splashActivity = splashActivity;
        this.startEgypt = startEgypt;
    }

    public void init(){
        EntityApps entityApps = new EntityApps();
        AppsFlyerLib.getInstance().setHost("","appsflyersdk.com");
        AppsFlyerLib.getInstance().init(startEgypt.aaappId, new AppsFlyerConversionListener() {
            @Override
            public void onConversionDataSuccess(Map<String, Object> map) {
                if (appsStart){
                    appsStart = false;
                    try {
                        entityApps.setAf_status(Objects.requireNonNull(map.get(fFd.getQ1())).toString());
                    }catch (Exception e){
                        entityApps.setAf_status(fFd.getNnn());
                    }

                    try {
                        entityApps.setAf_channel(Objects.requireNonNull(map.get(fFd.getQ2())).toString());
                    }catch (Exception e){
                        entityApps.setAf_channel(fFd.getNnn());
                    }

                    try {
                        entityApps.setMedia_source(Objects.requireNonNull(map.get(fFd.getQ3())).toString());
                    }catch (Exception e){
                        entityApps.setMedia_source(fFd.getNnn());
                    }

                    try {
                        entityApps.setCampaign(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ4())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setCampaign(fFd.getNnn());
                    }

                    try {
                        entityApps.setAf_ad(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ5())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setAf_ad(fFd.getNnn());
                    }

                    try {
                        entityApps.setCampaign_id(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ6())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setCampaign_id(fFd.getNnn());
                    }
                    try {
                        entityApps.setAdset_id(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ7())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setAdset_id(fFd.getNnn());
                    }
                    try {
                        entityApps.setAd_id(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ8())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setAd_id(fFd.getNnn());
                    }
                    try {
                        entityApps.setAdset(URLEncoder.encode(Objects.requireNonNull(map.get(fFd.getQ9())).toString(),fFd.getUtf()));
                    }catch (Exception e){
                        entityApps.setAdset(fFd.getNnn());
                    }
                    saveApps(entityApps);
                }
            }

            @Override
            public void onConversionDataFail(String s) {
                if (appsStart){
                    appsStart = false;
                    err(entityApps);
                    saveApps(entityApps);
                }
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> map) {
                if (appsStart){
                    appsStart = false;
                    err(entityApps);
                    saveApps(entityApps);
                }
            }

            @Override
            public void onAttributionFailure(String s) {
                if (appsStart){
                    appsStart = false;
                    err(entityApps);
                    saveApps(entityApps);
                }
            }
        },splashActivity);
        AppsFlyerLib.getInstance().start(splashActivity);
    }

    private void err(EntityApps entityApps){
        entityApps.setAf_status(fFd.getNnn());
        entityApps.setAf_channel(fFd.getNnn());
        entityApps.setMedia_source(fFd.getNnn());
        entityApps.setCampaign(fFd.getNnn());
        entityApps.setAf_ad(fFd.getNnn());
        entityApps.setCampaign_id(fFd.getNnn());
        entityApps.setAdset_id(fFd.getNnn());
        entityApps.setAd_id(fFd.getNnn());
        entityApps.setAdset(fFd.getNnn());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    private void saveApps(EntityApps entityApps){
        Completable.fromAction(() -> userDao.insertApss(entityApps))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.d("www","yyeeey"),
                        throwable -> Log.e("wwww",throwable.getMessage()));
    }
}
