package com.pikpok.hrc.startEgypt;

import static com.pikpok.hrc.Application.fFd;
import static com.pikpok.hrc.Application.userDao;
import static com.pikpok.hrc.startEgypt.StartEgypt.ccc;

import android.util.Log;

import com.onesignal.OneSignal;
import com.pikpok.hrc.data.dfd.EntityDataMob;
import com.pikpok.hrc.data.grgr.EntityDepp;

import java.net.URLDecoder;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class TagEgypt {
    String[] y;
    String[] sub = null;
    String s;
    String tte;

    public void tagEgypt() {

        userDao.getDeep().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<EntityDepp>() {
                    @Override
                    public void onSuccess(EntityDepp entityDepp) {
                        try {
                            y = URLDecoder.decode(entityDepp.getDeep(), fFd.getUtf()).split("://");
                        } catch (Exception e) {
                            y = null;
                        }
                        try {
                            s = Objects.requireNonNull(y)[1];
                        } catch (Exception e) {
                            s = null;
                        }
                        n(entityDepp.getDeep());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("weq", e.getMessage());
                    }
                });
    }


    private void n(String ss) {
        try {
            if (!Objects.equals(ss, fFd.getNnn())) {

                sub = Objects.requireNonNull(s).split("_");
            }
            if (!Objects.equals(ccc, fFd.getNnn())) {
                sub = ccc.split("_");
            }
        } catch (Exception e) {
            Log.e("dsdds", e.getMessage());
        }

        if (sub != null) {
            tte = sub[1];
        } else {
            tte = fFd.getOrg();
        }
        userDao.getDataMob().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableSingleObserver<EntityDataMob>() {
                    @Override
                    public void onSuccess(EntityDataMob entityDataMob) {
                        OneSignal.setExternalUserId(entityDataMob.getAppId());
                        OneSignal.sendTag("sub_app", tte);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("rere", e.getMessage());
                    }
                });

    }
}
