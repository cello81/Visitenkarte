package ch.marcini.visitenkarte;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity1 extends Activity {

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_activity1);

        int w=getWindowManager().getDefaultDisplay().getWidth()-25;
        int h=getWindowManager().getDefaultDisplay().getHeight()-25;

        BallViewOld ballView=new BallViewOld(this,w,h);
        setContentView(ballView);        
    }

    public class BallViewOld extends SurfaceView implements SurfaceHolder.Callback {

        private Bitmap bitmap ;
        private MyThread thread;
        private int x=20,y=20;int width,height;

        public BallViewOld(Context context,int w,int h) {
            super(context);

            width=w;
            height=h;
            thread=new MyThread(getHolder(),this);
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
            return true;
        }

        //@Override
        public void surfaceCreated(SurfaceHolder holder) {

            thread.startrun(true);
            thread.start();

        }

        //@Override
        public void surfaceDestroyed(SurfaceHolder holder) {


            thread.startrun(false);
            thread.stop();

        }

		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			
		}   
     }
}
