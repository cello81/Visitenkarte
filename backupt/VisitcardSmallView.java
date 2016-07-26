package ch.marcini.visitenkarte;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class VisitcardSmallView extends SurfaceView implements SurfaceHolder.Callback {
    private Bitmap bitmap ;
    private int x,y;int width,height;

    public VisitcardSmallView(Context context,int w,int h) {
        super(context);

        width=w;
        height=h;
        x=width/2;
        y=height/2;
        getHolder().addCallback(this);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        bitmap =BitmapFactory.decodeResource(getResources(), R.drawable.visitenkartesmall);
        canvas.drawColor(Color.WHITE);//To make background 
        canvas.drawBitmap(bitmap,x-(bitmap.getWidth()/2),y-(bitmap.getHeight()/2),null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();

        if(x<25)
            x=25;
        if(x> width)   
            x=width;
        if(y <25)
            y=25;
        if(y > 405)
            y=405;

        updateBall();

        return true;
    }

    //@Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
        // TODO Auto-generated method stub
    }

   // @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

   // @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
    }

    private void updateBall() {
        Canvas canvas = null;
        try {
            canvas = getHolder().lockCanvas(null);
            synchronized (getHolder()) {
                this.onDraw(canvas);
            }
        }
        finally {
            if (canvas != null) {
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }   
}