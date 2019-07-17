package com.andella.androidchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setTitle("About ALC");
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        WebView mywebview = (WebView) findViewById(R.id.webView);
        mywebview.setWebViewClient(
                new SSLTolerentWebViewClient()
        );
        mywebview.loadUrl("http://andela.com/alc/");
    }
}

class SSLTolerentWebViewClient extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        handler.proceed(); // Ignore SSL certificate errors
    }
}
