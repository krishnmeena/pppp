package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;

public class You extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);


        /*webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://m.youtube.com/watch?start_radio=1&list=RDPc2apoqxL18&v=Pc2apoqxL18");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
         */
        getWindow().setFormat(PixelFormat.UNKNOWN);

//displays a video file
        VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView1);

        String uriPath2 = "android.resource://com.example.myapplication/"+R.raw.movie;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();
    }
}
