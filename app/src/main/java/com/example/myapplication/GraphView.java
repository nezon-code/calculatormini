package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;


public class GraphView extends View {
    private float zoom;
    private float offsetX;
    private float offsetY;
    private Paint graphP;
    ArrayList<GraphFunction> functions = new ArrayList<GraphFunction>();
    public GraphView(Context context, float z, float X, float Y)
    {
        super(context);
        zoom = z;
        offsetX = X;
        offsetY = Y;
    }

    public GraphView(Context context)
    {
        super(context);
        offsetX = 0;
        offsetY = 0;
        zoom = 100;
        graphP = new Paint();
        graphP.setColor(Color.RED);
        graphP.setStrokeWidth(10f);
        graphP.setStyle(Paint.Style.STROKE);
    }

    public void pan (float x, float y)
    {
        offsetX+=x;
        offsetY+=y;
    }
    public void updateGraph()
    {
        invalidate();
    }
    public float getOffSetX()
    {
        return offsetX;
    }
    public float getOffsetY()
    {
        return offsetY;
    }

    public void addFunction(GraphFunction f)
    {
        functions.add(f);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        for (GraphFunction f : functions)
        {
            if (f.getExpression().contains("x"))
            {
                float prevX = 0;
                float prevY = 0;
                for (float i = 0; i < 400; i += 5)
                {
                    double g = f.evaluate(new String[]{"x"}, new double[]{i});
                    canvas.drawLine(prevX, prevY, i, (float) g, graphP);
                    prevX = i;
                    prevY = (float) g;
                }
            }
        }

    }
}
