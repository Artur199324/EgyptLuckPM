package com.pikpok.hrc.startEgypt.dh;

import static com.pikpok.hrc.Application.fFd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;

public class Jdgd {
    public void ll(Activity activity, WebResourceRequest request){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(request.getUrl().toString()));
        activity.startActivity(Intent.createChooser(intent, fFd.getE6()));
    }
}
