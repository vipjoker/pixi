package com.vipjoker_studio.jsgame;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    WebView webView;
    TextView textView;
    Button btnCall;
    JsHandler jsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        textView = (TextView)findViewById(R.id.tvInfo);
        btnCall = (Button)findViewById(R.id.btnCallJs);
        btnCall.setOnClickListener(this);
        initWebView();
    }

    private void initWebView(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setBackgroundColor(Color.RED);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);


        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);

        webView.getSettings().setAppCacheMaxSize(1024 * 8);
        webView.getSettings().setAppCacheEnabled(true);

        jsHandler = new JsHandler(this, webView);
        webView.addJavascriptInterface(jsHandler, "JsHandler");

        webView.getSettings().setUseWideViewPort(false);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                super.onPageStarted(view, url, favicon);
                //Toast.makeText(TableContentsWithDisplay.this, "url "+url, Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //Toast.makeText(TableContentsWithDisplay.this, "Width " + view.getWidth() +" *** " + "Height " + view.getHeight(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceivedSslError(WebView view,
                                           SslErrorHandler handler, SslError error) {
                // TODO Auto-generated method stub
                super.onReceivedSslError(view, handler, error);
                //Toast.makeText(TableContentsWithDisplay.this, "error "+error, Toast.LENGTH_SHORT).show();

            }
        });

        // these settings speed up page load into the webview
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.requestFocus(View.FOCUS_DOWN);
        // load the main.html file that kept in assets folder


        webView.loadDataWithBaseURL("file:///android_asset/","<!DOCTYPE html>\n" +
                "\n" +
                "<html>\n" +
                "\n" +
                "<head>\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<img src=\"mario.png\" alt=\"Mario\"></img>\n" +
                "<input type=\"button\" onClick=\"callTojavaFn()\" value=\"Call Java Fn\">\n" +
                "<input type=\"button\" onClick=\"callMy()\" value=\"Console\"/>\n" +
                "</body>\n" +
                "<script src=\"js/pixi.min.js\"></script>\n" +
                "<script language=\"javascript\" src=\"js/main.js\"></script>\n" +
                "</html>\n","text/html", "UTF-8", null);

//        webView.loadUrl("file:///android_asset/index.html");

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCallJs:

                try {
                    for (String s : getAssets().list("assets/")) {
                        Log.i("Assets", "onClick: " + s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


                jsHandler.javaFnCall("Hey, Im calling from Android-Java");
                break;

            default:
                break;
        }
    }
}
