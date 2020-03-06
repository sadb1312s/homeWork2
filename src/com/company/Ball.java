package com.company;

public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        if(direction < -180 || direction > 180)
            try {
                throw new Exception("direction must be from -180 to 180");
            } catch (Exception e) {
                e.printStackTrace();
            }

        this.x = x;
        this.y = y;
        this.radius = radius;
        xDelta = (float) (speed * Math.cos(Math.toRadians(direction)));
        yDelta = (float) (- speed * Math.sin(Math.toRadians(direction)));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getXDelta() {
        return xDelta;
    }

    public void setXDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getYDelta() {
        return yDelta;
    }

    public void setYDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        x += xDelta;
        y += yDelta;
    }

    public void reflectHorizontal(){
        xDelta *= -1;
    }

    public void reflectVertical(){
        yDelta *= -1;
    }

    @Override
    public String toString() {
        return "Ball[("+x+","+y+"),speed=("+xDelta+","+yDelta+")";
    }
}
