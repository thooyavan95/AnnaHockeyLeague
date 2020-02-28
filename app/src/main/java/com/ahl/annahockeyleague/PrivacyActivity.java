package com.ahl.annahockeyleague;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

        WebView webView = findViewById(R.id.privacy_web_view);
        webView.loadUrl("https://www.google.com");
    }
}
