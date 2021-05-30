package unimas.my.crudapplication;

import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FullMap extends Activity {

    ViewPager viewPager;
    WebView myWebView;

    String mapPath = "https://www.google.com/maps/place";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_map);
        myWebView = (WebView)findViewById(R.id.mapview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView .getSettings().setDomStorageEnabled(true);

        myWebView.loadUrl(mapPath);

    }

}