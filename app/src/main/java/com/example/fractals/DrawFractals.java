package com.example.fractals;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawFractals extends View {
    Paint paint;
    int w, h;

    public DrawFractals(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        drawCircles(canvas,w/2,h/2,200);
        paint.setColor(Color.RED);
        drawRect(canvas,w/2,h/2,100);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.w = w;
        this.h = h;
    }
    // рекурсивное рисование окружностей
    public void drawCircles(Canvas canvas, int x, int y, int r){

        canvas.drawCircle(x, y, r, paint);
        if(r > 50) {
            drawCircles(canvas, x, y - r, r / 2);
            drawCircles(canvas, x + r, y, r / 2);
            drawCircles(canvas, x, y + r, r / 2);
            drawCircles(canvas, x - r, y, r / 2);
        }
    }
    // рекурсивное рисование квадратов
    public void drawRect(Canvas canvas, int x, int y, int r){

        canvas.drawRect(x, y, x+r, y+r, paint);
        if(r > 20) {
            drawRect(canvas, x, y - r, r / 2);
            drawRect(canvas, x + r, y, r / 2);
            drawRect(canvas, x, y + r, r / 2);
            drawRect(canvas, x - r, y, r / 2);
        }
    }
}
