package com.pikpok.hrc.startEgypt.dh;

import static com.pikpok.hrc.Application.fFd;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebResourceRequest;

public class Gdgdg {

    public void ccj(Activity activity, WebResourceRequest request){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType(fFd.getE2());
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{request.getUrl().toString().replace(fFd.getE3(), "")});
        activity.startActivity(Intent.createChooser(intent, fFd.getE4()));
    }
}
