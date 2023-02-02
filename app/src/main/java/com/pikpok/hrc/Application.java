package com.pikpok.hrc;

import android.annotation.SuppressLint;
import android.os.BatteryManager;
import android.provider.Settings;
import android.util.Log;

import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;
import com.pikpok.hrc.data.dfd.EntityDataMob;
import com.pikpok.hrc.data.dfd.FFd;
import com.pikpok.hrc.data.UserDao;
import com.pikpok.hrc.data.UserDataBase;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Application extends android.app.Application {

    public static UserDao userDao;
    public static boolean appsStart = true;
    public static FFd fFd;
    @Override
    public void onCreate() {
        super.onCreate();
        fFd = new FFd();
        userDao = UserDataBase.Companion.getDataBase(this).userDao();
        initDataMob();
        OneSignal.initWithContext(this);
        OneSignal.setAppId("53ad6edb-563a-40b8-b308-8e402e6bb546");
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
    }

    @SuppressLint("CheckResult")
    private void initDataMob() {
        EntityDataMob entityDataMob = new EntityDataMob();
        int a;
        float b;
        try {
            entityDataMob.setAppId(AppsFlyerLib.getInstance().getAppsFlyerUID(this));
        } catch (Exception e) {
            entityDataMob.setAppId("null");
        }

        try {
            a = Settings.Secure.getInt(getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0);
        } catch (Exception e) {
            a = 0;
        }

        try {
            BatteryManager batteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
            b = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        } catch (Exception e) {
            b = 100.0f;
        }

        if (a != 0) {
            entityDataMob.setAdb("true");
        } else {
            entityDataMob.setAdb("false");
        }

        entityDataMob.setBat(String.valueOf(b));

        SingleOnSubscribe<String> single = null;
        try {
            single = e -> e.onSuccess(AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId());
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //noinspection ResultOfMethodCallIgnored
            Single.create(single)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError(throwable -> saveDatamob("null",entityDataMob))
                    .subscribe(s -> saveDatamob(s,entityDataMob));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressLint("CheckResult")
    private void saveDatamob(String s, EntityDataMob entityDataMob){
        entityDataMob.setGaid(s);
        //noinspection ResultOfMethodCallIgnored
        Completable.fromAction(() -> userDao.insertDataMob(entityDataMob))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()-> Log.d("www","dddd"),
                        throwable -> Log.e("wwww",throwable.getMessage()));
    }
}
