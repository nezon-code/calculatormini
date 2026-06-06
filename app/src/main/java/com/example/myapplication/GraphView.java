package com.example.myapplication;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;


public class GraphView extends View {
    float zoom;
    float offsetX;
    float offsetY;
    Paint axisP;
    Paint gridP;
    Paint graphP;
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
    }
}
