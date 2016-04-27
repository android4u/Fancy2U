package com.meunicorn.fancy2u.UI.Activivty;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.meunicorn.fancy2u.MyApplication;
import com.meunicorn.fancy2u.Utils.SpUtil;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webView=new WebView(this);
        setContentView(webView);
        final String dribbbleUrl="https://dribbble.com/oauth/authorize?client_id=a2874a8fe925e0667fcff24ee9bc44a1e23212372a0181fe1722943325aacf07";
        webView.loadUrl(dribbbleUrl);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.i("ACCESSTOKEN", "onCreate: "+url);
                if (url.contains("code")){
                    Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
                    SpUtil spUtil=SpUtil.make(LoginActivity.this);
                    spUtil.setStringData("ACCESS_TOKEN",url.split("=")[1]);
                    spUtil.setBooleanData("isLogin",true);
                    finish();
                }
                return true;
            }
        });
    }
}
