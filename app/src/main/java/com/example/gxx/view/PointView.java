package com.example.gxx.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PointView extends View {
	private int color = Color.RED;
	private int radius = 10;
	public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public PointView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public PointView(Context context) {
		super(context);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int measuredWidth = radius * 2 + getPaddingLeft() + getPaddingRight();
		setMeasuredDimension(measuredWidth, measuredWidth);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Rect rect = canvas.getClipBounds();
		Paint paint=new Paint();
		paint.setColor(this.color);
		paint.setStyle(Style.FILL_AND_STROKE);
		paint.setAntiAlias(true);
		canvas.drawCircle(rect.centerX(), rect.centerY(), radius, paint);
		Log.i("gxx", this.toString());
	}

	public void setColor(int color) {
		this.color = color;
		
	}
	public void  setRaidus(int raduis) {
		this.radius=raduis;
		
 	}
    public void changeColor(int newcolor)
    {
    	this.color=newcolor;
    	invalidate();
    }
    public void changeR(int newradius)
    {
    	this.radius=newradius;
    	invalidate();
    }
}
