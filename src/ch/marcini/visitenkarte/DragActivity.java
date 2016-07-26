package ch.marcini.visitenkarte;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class DragActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int h = displaymetrics.heightPixels;
        int w = displaymetrics.widthPixels;
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
        BallView ballView=new BallView(this, w, h);
        setContentView(ballView);
       // ballView.onDraw(null);
    }
}

