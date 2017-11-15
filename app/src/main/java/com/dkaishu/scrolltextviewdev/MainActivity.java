package com.dkaishu.scrolltextviewdev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.dkaishu.scrolltextview.ScrollTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ScrollTextView stvExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stvExample = (ScrollTextView) findViewById(R.id.stv_example);

        List<String> textList = new ArrayList<>();
        List<ScrollTextView.OnScrollClickListener> clickListeners = new ArrayList<>();
        List<ScrollTextView.OnScrollListener> scrollListeners = new ArrayList<>();

        textList.add("Be yourself, never give up. The adolescent girl from Tennessee is standing on the stage of a drama summer camp in upstate New York. It's a beautiful day. But the girl doesn't feel beautiful. She's not the leggy, glamorous Hollywood type.");
        textList.add("一名少女由田纳西州来到纽约北部，她站在戏剧夏令营的舞台上，虽然天气是那么好，她的心情却一点也不好。");


        clickListeners.add(new ScrollTextView.OnScrollClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "this is text one", Toast.LENGTH_SHORT).show();
            }
        });

        clickListeners.add(new ScrollTextView.OnScrollClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "this is text two", Toast.LENGTH_SHORT).show();
            }
        });


        scrollListeners.add(new ScrollTextView.OnScrollListener() {
            @Override
            public void onScrollStart(List<ScrollTextView.TextInfo> passedTextInfos) {
                String text = "";
                for (ScrollTextView.TextInfo s : passedTextInfos) {
                    text = text + s.getText();
                }
                Log.e(TAG, "" + text);
            }

            @Override
            public void onScrollEnd(List<ScrollTextView.TextInfo> incommingTextInfos) {
                String text = "";
                for (ScrollTextView.TextInfo s : incommingTextInfos) {
                    text = text + s.getText();
                }
                Log.e(TAG, "" + text);
            }
        });

//        stvExample.setScrollTime(500);
//        stvExample.setSpanTime(3000);
//        stvExample.setTextColor();
//        stvExample.setTextSize();
        stvExample.setTextContent(textList, clickListeners, scrollListeners);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        stvExample.startTextScroll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stvExample.stopTextScroll();
    }
}