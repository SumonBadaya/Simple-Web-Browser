package com.net.sb.sbweb;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button goButton;
    ImageButton home,sMedia;
    WebView wb;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url=(EditText) findViewById(R.id.editText);
        goButton=(Button)findViewById(R.id.button);
        wb=(WebView)findViewById(R.id.webView);

        home=(ImageButton)findViewById(R.id.imageButton);
        sMedia=(ImageButton)findViewById(R.id.imageButton2);
        progress=(ProgressBar)findViewById(R.id.progressBar);

        wb.setWebViewClient(new MyWevViewClient());//set view into web-view
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebChromeClient(new WebChromeClient());

        wb.loadUrl("http://google.com");//default set-URL

    }


    public void goButton(View v){
        if(! url.getText().equals("")){
            wb.loadUrl("http://"+url.getText().toString());
        }else{
            Toast.makeText(this,"Pleas, Write something ...",Toast.LENGTH_SHORT).show();
        }
    }

    public void home(View v){
        wb.loadUrl("http://google.com");//default set-URL
    }
    public void google(View v){
        wb.loadUrl("https://www.google.com");//default set-URL
    }
    public void gmail(View v){
        wb.loadUrl("https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");//default set-URL
    }
    public void facebook(View v){
        wb.loadUrl("https://www.facebook.com");//default set-URL
    }
    public void youtube(View v){
        wb.loadUrl("https://www.youtube.com");//default set-URL
    }


    /////////////////////override methods//////////////////////

    @Override
    public void onBackPressed() {
        if(wb.canGoBack()){
            wb.goBack();
        }else {
            super.onBackPressed();
        }
    }






    // progress bar with web view(deterministic progress bar)

    public class MyWevViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progress.setVisibility(view.getVisibility());
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.setVisibility(view.GONE);
        }
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            progress.setProgress(view.getProgress());
        }
    }

}
