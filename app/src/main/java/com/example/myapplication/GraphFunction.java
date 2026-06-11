package com.example.myapplication;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.HashMap;
public class GraphFunction {
    private String exp;
    private int color;
    private boolean visible;
    public GraphFunction() {
        exp = "";
        color = 0;
        visible = true;
    }

    public GraphFunction(String expr)
    {
        exp = expr;
        color = 0;
        visible = true;
    }

    public GraphFunction(String expr, int c, boolean v) {
        exp = expr;
        color = c;
        visible = v;
    }

    public double evaluate(String[] vars, double[] values)
    {
        Expression e = new Expression(exp);
        for (int i = 0; i < vars.length; i++)
        {
            e.addArguments(new Argument(vars[i], values[i]));
        }
        System.out.println(e);
        System.out.println(e.calculate() + " rawr uwu :3 3;3");
        return e.calculate();
    }

    public String getExpression()
    {
        return exp;
    }
    public void setExpression(String ep)
    {
        exp = ep;
    }
}
