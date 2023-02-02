package com.pikpok.hrc.startEgypt.dh;

import android.net.Uri;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Wsds {

    public static final int INPUT_FILE_REQUEST_CODE = 1;
    public static final int FILECHOOSER_RESULTCODE = 1;
    public static ValueCallback<Uri> mUploadMessage;
    public static Uri mCapturedImageURI = null;
    public static ValueCallback<Uri[]> mFilePathCallback;
    public static String filePath;
    public static boolean ff = false;

    public static void fi(@SuppressWarnings("SameParameterValue") boolean a, @SuppressWarnings("SameParameterValue") boolean b , WebView webView) {
        webView.getSettings().setMixedContentMode(0);
        ofk(a, b, webView);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(a);
        webView.getSettings().setLoadWithOverviewMode(a);
        webView.getSettings().setAllowContentAccess(a);
        webView.getSettings().setBuiltInZoomControls(a);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString().replace("; wv", ""));
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            webView.getSettings().setSaveFormData(a);
        }
        webView.getSettings().setDisplayZoomControls(b);
        webView.getSettings().setSupportMultipleWindows(b);
    }

    private static void ofk(@SuppressWarnings("SameParameterValue") boolean a, @SuppressWarnings("SameParameterValue") boolean b , WebView webView){
        webView.getSettings().setJavaScriptEnabled(a);
        webView.getSettings().setDomStorageEnabled(a);
        webView.getSettings().setLoadsImagesAutomatically(a);
        webView.getSettings().setDatabaseEnabled(a);
        webView.getSettings().setUseWideViewPort(a);
        webView.getSettings().setAllowFileAccess(a);
    }
}
