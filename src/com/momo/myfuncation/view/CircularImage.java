package com.momo.myfuncation.view;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 圆头�?
 * 
 * @author jiajia 2014�?7�?17日下�?5:52:29
 */
public class CircularImage extends MaskedImage {
	public CircularImage(Context paramContext) {
		super(paramContext);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
	}

	public Bitmap createMask() {
		try{
			int i = getWidth();
			int j = getHeight();
			Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
			Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
			Canvas localCanvas = new Canvas(localBitmap);
			Paint localPaint = new Paint(1);
			localPaint.setColor(-16777216);
			float f1 = getWidth();
			float f2 = getHeight();
			RectF localRectF = new RectF(0.0F, 0.0F, f1, f2);
			localCanvas.drawOval(localRectF, localPaint);
			return localBitmap;
		}catch(Exception e){
			return null;
		}
		
	}
}