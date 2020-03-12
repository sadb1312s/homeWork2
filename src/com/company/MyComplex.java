package com.company;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if(imag < 0)
            return "(" + real +""+imag+"i)";
        else
            return "(" + real +"+"+imag+"i)";
    }

    public boolean isReal(){
        if(real != 0d) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isImaginary(){
        if(imag != 0d) {
            return true;
        }else {
            return false;
        }
    }

    public boolean equals(double real, double imag){
        return equals(new MyComplex(real,imag));
    }

    public boolean equals(MyComplex another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;

        if (Double.compare(another.real, real) != 0) return false;
        return Double.compare(another.imag, imag) == 0;
    }

    public double magnitude(){
        return Math.sqrt(Math.pow(real,2) + Math.pow(imag,2));
    }

    public double argument(){
        if(real > 0)
            return Math.atan(imag/real);
        if(real < 0 && imag >= 0)
            return Math.atan(imag/real) + Math.PI;
        if(real < 0 && imag < 0)
            return Math.atan(imag/real) - Math.PI;

        return 0;
    }

    public MyComplex add(MyComplex right){
        real += right.real;
        imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right){
        return new MyComplex(real,imag).add(right);
    }

    public MyComplex subtract(MyComplex right){
        real -= right.real;
        imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right){
        return new MyComplex(real,imag).subtract(right);
    }

    public MyComplex multiply(MyComplex right){
        double tReal = real;
        real = (real * right.real) - (imag * right.imag);
        imag = (tReal * right.imag) + (imag * right.real);
        return this;
    }

    public MyComplex divide(MyComplex right){
        double nReal = (real * right.real + imag * right.imag) / (Math.pow(right.real,2) + Math.pow(right.imag,2));
        double nImag = (right.real * imag - real * right.imag) / (Math.pow(right.real,2) + Math.pow(right.imag,2));

        real = nReal;
        imag = nImag;

        return this;
    }

    public MyComplex conjugate(){
        return new MyComplex(real,imag*-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyComplex myComplex = (MyComplex) o;

        return (Double.compare(real, myComplex.real) != 0)
                && Double.compare(imag, myComplex.imag) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + Double.hashCode(real);
        result = 31 * result + Double.hashCode(imag);

        return result;
    }
}
