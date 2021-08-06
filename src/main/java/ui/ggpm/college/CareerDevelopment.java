package ui.ggpm.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CareerDevelopment extends AppCompatActivity {
    WebView webView;
    private String webUrl="https://jeecup.nic.in/webinfo/public/home.aspx";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_career_development);
        webView=findViewById(R.id.mywebview);
        webView.loadUrl(webUrl);
        webView.setWebViewClient(new WebViewClient() {
                                     @Override
                                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                         view.loadUrl(url);
                                         return true;

                                     }
                                 }

        );

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();

        else
            super.onBackPressed();
    }
    }

