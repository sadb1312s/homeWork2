package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class MyPolynomial {

    class polyInst{
        double n;
        double deg;

        @Override
        public String toString() {
            return "polyInst{" +
                    "n=" + n +
                    ", deg=" + deg +
                    '}';
        }
    }

    private double[] coeffs;

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree(){
        return coeffs.length - 1;
    }

    @Override
    public String toString() {

        List list = new ArrayList();

        int len = getDegree();

        for(int i = 0; i < coeffs.length; i++){
            String s = "";
            double tCoef = coeffs[i];
            int deg = len - i;

            if(tCoef != 0){
                if(tCoef > 1 || i == coeffs.length - 1)
                    s += tCoef;

                if( i != coeffs.length - 1)
                    s += "X";

                if(deg > 1)
                    s += "^"+deg;

                list.add(s);

            }else
            {
                continue;
            }


            //System.out.println(s);


        }

        String returnS = "";
        for(int i = 0; i < list.size(); i++){
            returnS += list.get(i);
            if(i != list.size() - 1){
                returnS += " + ";
            }
        }

        return returnS;
    }

    public double evaluate(double x){
        double res = 0;

        for(int i = 0; i < coeffs.length; i++){
            double tCoef = coeffs[i];
            if(tCoef != 0){
                double deg = coeffs.length - i - 1;

                res += tCoef * Math.pow(x, deg);
            }

        }

        return res;
    }

    public MyPolynomial add(MyPolynomial right){
        int degThis = getDegree() + 1;
        int degRight = right.getDegree() + 1;

        if(degThis >= degRight){
            double[] newCoeffs = new double[degThis];

            //degThis - degRight
            //copy

            int startI = degThis - degRight;
            int j = 0;
            System.out.println("!! "+startI);
            for(int i = 0 ; i < newCoeffs.length; i++){
                newCoeffs[i] = coeffs[i];

                if(i >= startI){
                    newCoeffs[i] += right.coeffs[j];
                    j++;
                }
            }





            return new MyPolynomial(newCoeffs);
        }else {
            return right.add(this);
        }
    }

    public MyPolynomial multiply(MyPolynomial right){



        int degThis = getDegree() + 1;
        int degRight = right.getDegree() + 1;

        if(degThis >= degRight){
            List listParts = new ArrayList();


            for(int i = 0; i < degThis; i++){
                List mElements = new ArrayList();

                for(int j = 0; j < degRight; j++){
                    polyInst t = new polyInst();
                    t.n = coeffs[i] * right.coeffs[j];
                    t.deg = (degThis - i - 1) + (degRight - j - 1);
                    mElements.add(t);
                }

                listParts.add(mElements);
            }




            return new MyPolynomial(coeffs); // <---- attention
        }else {
            return right.multiply(this);
        }

    }

    //help methods
    private void addLists(List list){
        for(Object o : list){
            System.out.println(o);
        }
    }


}
