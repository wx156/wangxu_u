package com.kfm.base.classes.exer;

public class GeometryCalculator {
    private double radius;
    private double width;
    private double height;
    public double calculateCircleArea(double radius){
        return 3.14 * Math.pow(radius,2);
    }
    public double calculateRectangleArea(double width, double height){
        return width * height;
    }
}
