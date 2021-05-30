package unimas.my.crudapplication;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends Activity {

    ViewPager viewPager;
    WebView myWebView;
    Button btn;

    String mapPath = "https://www.google.com/maps/place/Dhaka/@23.7808875,90.2792379,11z/data=!3m1!4b1!4m5!3m4!1s0x3755b8b087026b81:0x8fa563bbdd5904c2!8m2!3d23.810332!4d90.4125181";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView)findViewById(R.id.mapview);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        btn= findViewById(R.id.btn_next);

        myWebView.loadUrl(mapPath);


        viewPager=(ViewPager) findViewById(R.id.viewPager);
        ImageAdapter imageAdapter= new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);



    }

    public void onButtonClicked(View view) {
        Intent intent=new Intent(this, FullMap.class);
        startActivity(intent);
    }
}