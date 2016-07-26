package ch.marcini.visitenkarte;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("NewApi")
public class BallView extends SurfaceView  /* implements SurfaceHolder.Callback */ {
    private Bitmap visitCardSmall;
    private int x,y;int width,height;
    private int halfTheHeight, halfTheWidth;
    private boolean bDrawTheImage = true;
    public BallView(Context context,int w,int h) {
        super(context);

        width=w;
        height=h;
        x=width/2;
        y=height/2;
       // fuenfliberkopf = BitmapFactory.decodeResource(getResources(), R.drawable.fuenfliberkopf);
        visitCardSmall =BitmapFactory.decodeResource(getResources(), R.drawable.visitenkartesmall);
        halfTheWidth  = (visitCardSmall.getWidth() /2);
        halfTheHeight = (visitCardSmall.getHeight()/2);
        
        //getHolder().addCallback(this);
        setFocusable(true);
    }

	@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if (bDrawTheImage)
    	{
        	float scale  = ((float)x /  (float)width) - 1/2; // 0 is left, 1 is right
        	float xDraw = x - halfTheWidth + scale * halfTheWidth;
    		canvas.drawBitmap(visitCardSmall, xDraw, y- halfTheHeight, null );
    	}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();

        if ( x >= 500)
        {
        	bDrawTheImage = false;
        }
        else if (x <=30 && y >= 750)
        {
        	bDrawTheImage = true;
        }
  		//updateBall();
        return true;
    }
/*
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
*/
 /*   private void updateBall() {
        Canvas canvas = null;
        try {
            canvas = getHolder().lockCanvas(null);
            synchronized (getHolder()) {
                //this.onDraw(canvas);
            }
        }
        finally {
            if (canvas != null) {
                getHolder().unlockCanvasAndPost(canvas);
            }
        }
    }*/
}