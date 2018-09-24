package com.example.rtwm38.mygithub.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

import com.example.rtwm38.mygithub.R;

import okhttp3.internal.Util;

public class PRDiffActivity extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_req_diff);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        } else {
            String uri = extras.getString("html_url");
           // Log.d("jyotijyotijyoti", uri.concat("/files?utf8=✓&diff=split"));
            uri.concat("/files/Changes/");
            String temp = uri.concat("/files?utf8=✓&diff=split");
            Log.d("jyotijyotijyoti", temp);
            webView = findViewById(R.id.webView1);
            webView.setInitialScale(1);
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

            WebSettings settings = webView.getSettings();
            settings.setMinimumFontSize(10);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setSupportZoom(true);
            settings.setJavaScriptEnabled(true);
            webView.loadUrl(temp);

        }
    }
}
