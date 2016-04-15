package info.snist.smt1.frgments;

/**
 * Created by sai on 07-01-2016.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import info.snist.smt1.R;

public class fragment_partner extends Fragment {
    private WebView mWebView1;
    public fragment_partner(){}

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView1 = inflater.inflate(R.layout.layout_partner, container, false);

        mWebView1 = (WebView) rootView1.findViewById(R.id.activity_main_we);
        WebSettings webSettings = mWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView1.loadUrl("http://smt.16mb.com/Partners/");
        mWebView1.setWebViewClient(new MyAppWebViewClient() {
            @Override
            public void onPageFinished(WebView view1, String url1) {
                //hide loading image
                rootView1.findViewById(R.id.imageLoading2).setVisibility(View.GONE);
                rootView1.findViewById(R.id.textView11).setVisibility(View.GONE);
                rootView1.findViewById(R.id.textView10).setVisibility(View.GONE);
                rootView1.findViewById(R.id.progressBar3).setVisibility(View.GONE);



                //show webview
                rootView1.findViewById(R.id.activity_main_we).setVisibility(View.VISIBLE);
            }
        });
        return rootView1;
    }

}