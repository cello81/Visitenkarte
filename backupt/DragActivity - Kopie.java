package ch.marcini.visitenkarte;

import android.app.Activity;
import android.os.Bundle;

public class DragActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int w=getWindowManager().getDefaultDisplay().getWidth()-25;
        int h=getWindowManager().getDefaultDisplay().getHeight()-25;

        BallView ballView=new BallView(this,w,h);
        setContentView(ballView);
    }
}

