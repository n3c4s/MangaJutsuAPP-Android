package charly.bestia.mangajutsu_lectormanga;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import static android.widget.Toast.LENGTH_SHORT;
import static java.lang.System.currentTimeMillis;
 
import android.graphics.Bitmap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
 
@SuppressLint("SetJavaScriptEnabled") public class MainActivity extends Activity {
 
    private WebView myWebView;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
 
        this.myWebView = (WebView) this.findViewById(R.id.webView1);
 
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setBuiltInZoomControls(true);
 
        // Variable para crear mi nuevo newclient
        myWebView.setWebViewClient(new MyWebViewClient());
 
        myWebView.loadUrl("http://mangajutsu.com/index.html");
 
    }
 
    @Override
    public void onBackPressed() {
 
        // Check if there's history
        if (this.myWebView.canGoBack())
            this.myWebView.goBack();
        else
            super.onBackPressed();
 
    }
 
    private class MyWebViewClient extends WebViewClient {
 
        private long loadTime; // Web page loading time
 

 
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
 
            // Save start time
            this.loadTime = currentTimeMillis();
 
            // Show a toast
            Toast.makeText(getApplicationContext(),
                    "Iniciando Mangajutsu...", LENGTH_SHORT).show();
        }
 
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
 
            // Calculate load time
            this.loadTime = currentTimeMillis() - this.loadTime;
 
            
 
            
 
        }
    }
 



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
