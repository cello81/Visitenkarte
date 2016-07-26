package ch.marcini.visitenkarte;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class ScribbleWidget extends View {

	private Path path = null;
	private Paint paint = null;
	private Bitmap scribbleBitmap = null;
	
	public ScribbleWidget(Context context) {
		super(context);
		init();
	}

	public ScribbleWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ScribbleWidget(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init()
	{
		paint = new Paint();
		paint.setStrokeWidth(5.0f);
		paint.setStrokeCap(Cap.ROUND);
		paint.setStrokeJoin(Join.ROUND);
		paint.setStyle(Style.STROKE);
		
		setFocusable(true);
		setClickable(true);
	}
	
	
	
	protected void drawScribble(Canvas canvas) {
	

		if (path!=null)
		{
			canvas.drawPath(path, paint);
		}
	
	}

	@Override
	protected void onDraw(Canvas canvas) {
	
		super.onDraw(canvas);
		canvas.drawBitmap( scribbleBitmap, 0,0, paint );
		drawScribble(canvas);
	
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			Canvas canvas = new Canvas(scribbleBitmap);
			drawScribble(canvas);
			path = null;
			postInvalidate();
			return true;
		}
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			float x = event.getX();
			float y = event.getY();
			path = new Path();
			path.moveTo(x, y);
			postInvalidate();
			return true;
		}
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
			float x = event.getX();
			float y = event.getY();
		
			if (path!=null)
			{
				path.lineTo(x, y);
			}
			postInvalidate();
			return true;
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		
		if (scribbleBitmap!=null)
		{
			scribbleBitmap.recycle();
		}
		//scribbleBitmap = Bitmap.createBitmap(w,h,Config.ARGB_8888);
		scribbleBitmap = Bitmap.createBitmap(w,h,Config.ARGB_8888);
		Canvas canvas = new Canvas(scribbleBitmap);
		canvas.drawColor(Color.WHITE);
	}

	public void saveScribble(String output) {
		
		
	}
	
	

	
}
