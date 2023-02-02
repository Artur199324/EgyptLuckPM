package com.pikpok.hrc.ui.ffd;

import static com.pikpok.hrc.Application.fFd;
import static com.pikpok.hrc.Application.userDao;
import static com.pikpok.hrc.startEgypt.StartEgypt.star;
import static com.pikpok.hrc.startEgypt.StartEgypt.start;
import static com.pikpok.hrc.startEgypt.dh.Wsds.FILECHOOSER_RESULTCODE;
import static com.pikpok.hrc.startEgypt.dh.Wsds.INPUT_FILE_REQUEST_CODE;
import static com.pikpok.hrc.startEgypt.dh.Wsds.ff;
import static com.pikpok.hrc.startEgypt.dh.Wsds.fi;
import static com.pikpok.hrc.startEgypt.dh.Wsds.filePath;
import static com.pikpok.hrc.startEgypt.dh.Wsds.mCapturedImageURI;
import static com.pikpok.hrc.startEgypt.dh.Wsds.mFilePathCallback;
import static com.pikpok.hrc.startEgypt.dh.Wsds.mUploadMessage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.pikpok.hrc.data.grgr.EntityEgypt;
import com.pikpok.hrc.data.EntityGol;
import com.pikpok.hrc.startEgypt.dh.Gdgdg;
import com.pikpok.hrc.startEgypt.dh.Hyf;
import com.pikpok.hrc.startEgypt.dh.Jdgd;

import io.a6815fa22836cc6b3617ededfe.wdafobja2wojdb902.GathClient;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class EgyptLuckActivity extends AppCompatActivity {

    private WebView webView;
    private static GathClient gathClientee;
    public static boolean f = false;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            webView.saveState(outState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        try {
            webView.restoreState(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        Toast.makeText(this,"Loading...",Toast.LENGTH_LONG).show();
        userDao.getGol().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<EntityGol>() {
                    @Override
                    public void onSuccess(EntityGol entityGol) {
                        fi(true, false, webView);
                        CookieManager.getInstance().setAcceptCookie(true);
                        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
                        fs(true, false);
                        dj();
                        if (start) {
                            webView.loadUrl(entityGol.goo);
                        } else {

                            webView.loadUrl(star);
                        }
                        try {
                            gathClientee = new GathClient(EgyptLuckActivity.this, webView);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            fFd.gk(gathClientee);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                       if (f){
                           int Size = 8;
                           int Max = Size * Size;
                           int RC = 4;
                           int[] x = new int[RC];
                           int[] y = new int[RC];
                           int[][] Sp = new int[Size][Size];

                           for (int i = 0; i < RC; i++) {
                               x[i] = y[i] = 0;
                           }
                           x[1] = y[1] = Size - 1;
                           x[3] = 1;

                           for (int i = 0; i < Max; i++) {

                               Sp[x[2]][y[2]] = i + 1;

                               x[2] = x[2] + x[3];
                               y[2] = y[2] + y[3];

                               if (y[3] == 0) {
                                   if ((x[2] > x[0]) && (x[3] > 0)) {
                                       x[3] = 1;
                                   }
                                   if ((x[2] < x[1]) && (x[3] < 0)) {
                                       x[3] = -1;
                                   }
                                   if ((x[2] == x[1]) && (x[3] > 0)) {
                                       x[3] = 0;
                                       x[1]--;
                                       y[3] = 1;
                                   }
                                   if ((x[2] == x[0]) && (x[3] < 0)) {
                                       x[3] = 0;
                                       x[0]++;
                                       y[3] = -1;
                                   }
                               }
                               if (x[3] == 0) {
                                   if ((y[2] > y[0]) && (y[3] > 0)) {
                                       y[3] = 1;
                                   }
                                   if ((y[2] < y[1]) && (y[3] < 0)) {
                                       y[3] = -1;
                                   }
                                   if ((y[2] == y[1]) && (y[3] > 0)) {
                                       y[3] = 0;
                                       y[1]--;
                                       x[3] = -1;
                                   }
                                   if ((y[2] == x[0]) && (y[3] < 0)) {
                                       y[3] = 0;
                                       y[0]++;
                                       x[3] = 1;
                                   }
                               }
                           }
                           System.out.println();
                           for (int i = 0; i < Size; i++) {
                               for (int j = 0; j < Size; j++) {
                                   System.out.format("%4d", Sp[j][i]);
                               }
                               System.out.println();
                           }
                       }
                    }
                });
    }


    private void fs(@SuppressWarnings("SameParameterValue") boolean a, @SuppressWarnings("SameParameterValue") boolean b) {
        webView.setVerticalScrollBarEnabled(b);
        webView.setHorizontalScrollBarEnabled(b);
        webView.setLayerType(WebView.LAYER_TYPE_HARDWARE, null);
        webView.setSaveEnabled(a);
        webView.setFocusable(a);
        webView.setFocusableInTouchMode(a);
    }

    private void dj() {
        webView.setWebViewClient(new Weee(this, gathClientee, webView));
        webView.setWebChromeClient(new Ereq(this));
    }

    static class Weee extends WebViewClient {
        Activity activity;
        GathClient gathClient;
        WebView webView;

        public Weee(Activity activity, GathClient gathClient, WebView webView) {
            this.activity = activity;
            this.gathClient = gathClient;
            this.webView = webView;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            if (f) {
                int[][] a = {
                        {1, -2, 3},
                        {-4, -5, 6, 9},
                        {7},
                };

                for (int[] ints : a) {
                    for (int anInt : ints) {
                        System.out.println(anInt);
                    }
                }
            }
        }

        @Override
        public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
            if (f) {
                int[][] a = {
                        {1, -2, 3},
                        {-4, -5, 6, 9},
                        {7},
                };

                for (int[] innerArray : a) {
                    for (int data : innerArray) {
                        System.out.println(data);
                    }
                }
            }

            return super.onRenderProcessGone(view, detail);
        }

        @Override
        public void onReceivedLoginRequest(WebView view, String realm, @Nullable String account, String args) {
            if (f) {
                int[][][] test = {
                        {
                                {1, -2, 3},
                                {2, 3, 4}
                        },
                        {
                                {-4, -5, 6, 9},
                                {1},
                                {2, 3}
                        }
                };

                for (int[][] array2D : test) {
                    for (int[] array1D : array2D) {
                        for (int item : array1D) {
                            System.out.println(item);
                        }
                    }
                }
            }
            super.onReceivedLoginRequest(view, realm, account, args);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (view.getTitle().contains(fFd.getE10())) {
                activity.startActivity(new Intent(activity, MainActivity.class));
                activity.finish();
            } else {
                userDao.getEgypt().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSingleObserver<EntityEgypt>() {
                            @Override
                            public void onSuccess(EntityEgypt entityEgypt) {
                                if (f) {
                                    int[][] twoDimArray = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}};
                                    for (int i = 0; i < 3; i++) {
                                        for (int j = 0; j < 4; j++) {
                                            System.out.print(" " + twoDimArray[i][j] + " ");
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            @SuppressLint("CheckResult")
                            @Override
                            public void onError(Throwable e) {

                                EntityEgypt entityEgypt = new EntityEgypt(url);
                                Completable.fromAction(() -> userDao.insertEgypt(entityEgypt))
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(() ->
                                                        Log.d("weq", "egyptSSe"),
                                                throwable -> Log.e("ewwe", throwable.getMessage()));
                                try {
                                    gathClientee.sendURL(url);
                                } catch (Exception ee) {
                                    ee.printStackTrace();
                                }
                            }
                        });
            }
        }


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            if (request.getUrl().toString().startsWith(fFd.getE1())) {
                new Gdgdg().ccj(activity, request);

            } else if (request.getUrl().toString().startsWith(fFd.getE5())) {
                new Jdgd().ll(activity, request);
                if (f) {
                    String[][] chessBoard = new String[8][8];
                    for (int i = 0; i < chessBoard.length; i++) {
                        for (int j = 0; j < chessBoard[0].length; j++) {
                            if ((i + j) % 2 == 0) chessBoard[i][j] = "W";
                            else chessBoard[i][j] = "B";
                        }
                    }
                }

            } else if (request.getUrl().toString().startsWith(fFd.getE7())) {
                new Hyf().hg(activity, request);
                if (f) {
                    String[][] chessBoard = new String[8][8];
                    for (int i = 0; i < chessBoard.length; i++) {
                        for (int j = 0; j < chessBoard[0].length; j++) {
                            if ((i + j) % 2 == 0) chessBoard[i][j] = "W" + chessBoardCoord(j, i);
                            else chessBoard[i][j] = "B" + chessBoardCoord(j, i);
                        }
                    }

                    for (int i = 0; i < chessBoard.length; i++) {
                        for (int j = 0; j < chessBoard[0].length; j++) {
                            System.out.print(" " + chessBoard[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

            } else {
                request.getUrl();
                if (request.getUrl().toString().startsWith(fFd.getE8()) || request.getUrl().toString().startsWith(fFd.getE9()))
                    return false;
            }
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(request.getUrl().toString()));
                view.getContext().startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }
        }

        public static String chessBoardCoord(int a, int b) {
            String letters = "abcdefgh";
            String numbers = "87654321";
            if ((a > 7) || (b > 7)) return null;
            else return (Character.toString(letters.charAt(a)) + numbers.charAt(b));
        }
    }

    static class Ereq extends WebChromeClient {
        Activity activity;

        public Ereq(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (f) {
                int SIZE = 5;
                char[][] graph = new char[SIZE][];

                for (int i = 0; i < graph.length; i++) {

                    System.out.println(graph[i] == null);
                }

                for (int i = 0; i < graph.length; i++) {

                    int size = (int) (Math.round(Math.random() * 50) + 25);

                    graph[i] = new char[size];
                }

                for (int i = 0; i < graph.length; i++) {

                    System.out.println(graph[i].length);
                }
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override
        public void onCloseWindow(WebView window) {
            if (f) {
                int SIZE = 10;
                char[][] graph = new char[SIZE][SIZE];
                for (int i = 0; i < SIZE; i++) {

                    for (int j = 0; j < SIZE; j++) {
                        if (i == 0 || i == SIZE - 1 || j == 0 || j == SIZE - 1) {
                            graph[i][j] = '#';
                        } else {
                            graph[i][j] = ' ';
                        }
                    }
                }


                for (int i = 0; i < SIZE; i++) {

                    for (int j = 0; j < SIZE; j++) {

                        System.out.print(graph[i][j]);
                    }

                    System.out.println();
                }

            } else {
                super.onCloseWindow(window);
            }
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            if (f) {
                int SIZE = 10;

                char[][] graph = new char[SIZE][SIZE];


                for (int i = 0; i < SIZE; i++) {

                    for (int j = 0; j < SIZE; j++) {
                        graph[i][j] = '#';
                    }
                }

                for (int i = 0; i < SIZE; i++) {

                    for (int j = 0; j < SIZE; j++) {

                        System.out.print(graph[i][j]);
                    }
                    System.out.println();
                }
            } else {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (mFilePathCallback != null) {
                mFilePathCallback.onReceiveValue(null);
            }
            mFilePathCallback = filePathCallback;
            Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
            contentSelectionIntent.setType("*/*");
            Intent[] intentArray = new Intent[0];
            Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Select Option:");
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
            if (f) {
                int[][] array = new int[2][2];
                array[0][0] = 1;
                array[0][1] = 2;
                array[1][0] = 3;
                array[1][1] = 4;

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        System.out.print(array[i][j] + "\t");
                    }
                    System.out.println();
                }

            }
            activity.startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE);
            return true;
        }
    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            if (ff) {
                if (f) {
                    int[][] twoD = new int[5][4];
                    int i, j, k = 0;
                    for (i = 0; i < 5; i++) {
                        for (j = 0; j < 4; j++) {
                            twoD[i][j] = k++;
                            System.out.print(twoD[i][j] + " ");
                        }
                        System.out.println();
                    }
                }

                userDao.getEgypt().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new DisposableSingleObserver<EntityEgypt>() {
                            @Override
                            public void onSuccess(EntityEgypt entityEgypt) {
                                webView.loadUrl(entityEgypt.egypt);
                                if (f) {
                                    int[][] array = new int[4][];
                                    array[0] = new int[1];
                                    array[1] = new int[2];
                                    array[2] = new int[3];
                                    array[3] = new int[4];
                                    int i, j, k = 0;
                                    for (i = 0; i < 4; i++) {
                                        for (j = 0; j < i + 1; j++) {
                                            array[i][j] = k++;
                                            System.out.print(array[i][j] + " ");
                                        }
                                        System.out.println();
                                    }
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                pdk();
                            }
                        });
            }
            ff = true;
            webView.goBack();
            new Handler(Looper.getMainLooper()).postDelayed(() -> ff = false, 2550);
        }
    }

    private void pdk() {
        userDao.getGol().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<EntityGol>() {
                    @Override
                    public void onSuccess(EntityGol entityGol) {
                        webView.loadUrl(entityGol.goo);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("err", e.getMessage());
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data);
            if (f) {
                double[][] arrayTwoD = {
                        {0, 1, 2, 3},
                        {4, 5, 6, 7},
                        {8, 9, 10, 11},
                        {12, 13, 14, 15}
                };
                for (double[] arrayOneD : arrayTwoD) {
                    for (double element : arrayOneD) {
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            }
            return;
        }
        Uri[] results = null;
        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (filePath != null) {
                    results = new Uri[]{Uri.parse(filePath)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    results = new Uri[]{Uri.parse(dataString)};
                    if (f) {
                        int[][][] test = {
                                {
                                        {1, -2, 3},
                                        {2, 3, 4}
                                },
                                {
                                        {-4, -5, 6, 9},
                                        {1},
                                        {2, 3}
                                }
                        };

                        for (int[][] array2D : test) {
                            for (int[] array1D : array2D) {
                                for (int item : array1D) {
                                    System.out.println(item);
                                }
                            }
                        }
                    }
                }
            }
        }
        mFilePathCallback.onReceiveValue(results);
        mFilePathCallback = null;

        if (requestCode != FILECHOOSER_RESULTCODE || mUploadMessage == null) {
            super.onActivityResult(requestCode, resultCode, data);
            if (f) {
                int[][] a = {
                        {1, -2, 3},
                        {-4, -5, 6, 9},
                        {7},
                };

                for (int i = 0; i < a.length; ++i) {
                    for (int j = 0; j < a[i].length; ++j) {
                        System.out.println(a[i][j]);
                    }
                }
            }
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) //noinspection ConstantConditions
                result = null;
            else {
                if (f) {
                    int[][] a = {
                            {1, -2, 3},
                            {-4, -5, 6, 9},
                            {7},
                    };

                    for (int[] innerArray : a) {
                        for (int dd : innerArray) {
                            System.out.println(dd);
                        }
                    }
                }
                // retrieve from the private variable if the intent is null
                result = data == null ? mCapturedImageURI : data.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mUploadMessage.onReceiveValue(result);
        mUploadMessage = null;
    }
}