package com.pikpok.hrc.startEgypt;

import static com.pikpok.hrc.Application.userDao;

import android.annotation.SuppressLint;
import android.util.Log;

import com.pikpok.hrc.data.EntityGol;
import com.pikpok.hrc.ui.SplashActivity;

import org.json.JSONObject;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GoEgypt {

    StartInterfaseEgypt startInterfaseEgypt;
    SplashActivity splashActivity;

    public GoEgypt(StartInterfaseEgypt startInterfaseEgypt, SplashActivity splashActivity) {
        this.startInterfaseEgypt = startInterfaseEgypt;
        this.splashActivity = splashActivity;

    }

    public void go(String s) {
        SingleOnSubscribe<String> single = emitter -> {
            String agent;
            try {
                agent = System.getProperty("http.agent");
            } catch (Exception e) {
                agent = "ERROR";
            }

            try {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .readTimeout(20, TimeUnit.SECONDS)
                        .writeTimeout(20, TimeUnit.SECONDS)
                        .build();
                Request request = new Request.Builder()
                        .url(s)
                        .header("User-Agent", Objects.requireNonNull(agent))
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    emitter.onSuccess(Objects.requireNonNull(response.body()).string());
                }
            } catch (Exception e) {
                splashActivity.dialog();
            }
        };

        od(single);
    }

    @SuppressLint("CheckResult")
    private void od(SingleOnSubscribe<String> single) {
        //noinspection ResultOfMethodCallIgnored
        Single.create(single).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> splashActivity.dialog())
                .subscribe(s -> {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        try {
                            if (jsonObject.has("egypt")) {
                                startInterfaseEgypt.startEgypt(false);
                            } else if (jsonObject.has("egyptegypt")) {
                                Log.e("weq", jsonObject.getString("egyptegypt"));
                                EntityGol entityGol = new EntityGol(jsonObject.getString("egyptegypt"));
                                //noinspection ResultOfMethodCallIgnored
                                Completable.fromAction(() -> userDao.insertGol(entityGol))
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(() -> {
                                                    Log.d("weq", "egypt");
                                                    new TagEgypt().tagEgypt();
                                                    startInterfaseEgypt.startEgypt(true);
                                                },
                                                throwable -> Log.e("wwww", throwable.getMessage()));


                            }
                        } catch (Exception e) {
                            splashActivity.dialog();
                            e.printStackTrace();
                        }

                    } catch (Exception e) {
                        splashActivity.dialog();
                        e.printStackTrace();
                    }

                });
    }
}
