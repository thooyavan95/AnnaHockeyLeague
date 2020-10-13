package com.ahl.annahockeyleague;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

        if(getIntent().hasExtra("privacy")) {
            if (getIntent().getStringExtra("privacy").equals("privacy")) {
                WebView webView = findViewById(R.id.privacy_web_view);
                webView.loadUrl("https://anna-hockey-league.flycricket.io/privacy.html");
            }
        }


    }
}
