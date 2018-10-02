package jbenastey.org.gopku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by jbenastey on 31-May-17.
 */

public class SRumbaiLocation extends AppCompatActivity {

    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        browser = (WebView) findViewById(R.id.browser);
        browser.loadUrl("file:///android_asset/SRumbai.html");
        browser.getSettings().setJavaScriptEnabled(true);

    }
}
