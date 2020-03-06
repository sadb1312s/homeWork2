package com.company;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height ) {
        this.x1 = x;
        this.y1 = y;

        x2 = x1 + width;
        y2 = y1 - height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2 - x1;
    }

    public int getHeight(){
        return y1 - y2;
    }

    public boolean collides(Ball ball){
        if(x1 < ball.getX() - ball.getRadius() && ball.getX() <x2  - ball.getRadius()){
            if(ball.getY() + ball.getRadius() < y1 && ball.getY() - ball.getRadius() > y2){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Container[" +
                "(" + x1 +
                "," + y1 +
                "),(" + x2 +
                "," + y2 +
                ")]";
    }
}
