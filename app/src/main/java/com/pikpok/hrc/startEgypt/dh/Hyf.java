package com.pikpok.hrc.startEgypt.dh;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;

public class Hyf {
    public void hg(Activity activity, WebResourceRequest request){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
        activity.startActivity(intent);
    }
}
