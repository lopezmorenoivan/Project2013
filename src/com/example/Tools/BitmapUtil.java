package com.example.Tools;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapUtil {

	public static Bitmap byteArrayToBitmap(byte stream []) 
    { 
	    return BitmapFactory.decodeByteArray(stream,0,stream.length);
    } 

    public static byte[] bitmapToByteArray(Bitmap b) 
    { 
    	ByteArrayOutputStream bs = new ByteArrayOutputStream();
    	b.compress(Bitmap.CompressFormat.PNG, 50, bs);
    	return bs.toByteArray();
    } 
    
    public static Bitmap drawableToBitmap (Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable)drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), 
        		drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap); 
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
}
