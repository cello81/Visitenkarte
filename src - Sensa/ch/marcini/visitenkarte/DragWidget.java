package ch.marcini.visitenkarte;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("NewApi")
public class DragWidget extends View implements View.OnDragListener {

	private Paint paint;
	
	public DragWidget(Context context) {
		super(context);
		init();
	}
	
	
	private void init() {
		paint = new Paint();
		paint.setStrokeWidth(5.0f);
	}


	public DragWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	
	public DragWidget(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	
	protected void drawDrag(Canvas canvas) {
		super.onDraw(canvas);
	}
	
	 
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawDrag(canvas);
	}


//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//
//		if ( event.getAction() == MotionEvent.ACTION_DOWN)
//		{
//			
//			return true;
//		}
//		if ( event.getAction() == MotionEvent.ACTION_MOVE)
//		{
//			return true;
//		}
//		if ( event.getAction() == MotionEvent.ACTION_UP)
//		{
//			return true;
//		}
//		return super.onTouchEvent(event);
//	}


	public boolean onDrag(View arg0, DragEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setOnLongClickListener(OnLongClickListener l) {
		// TODO Auto-generated method stub
		super.setOnLongClickListener(l);
	}
	

}
