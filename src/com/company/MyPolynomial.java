package com.company;

import java.util.*;

public class MyPolynomial {

    //help class
    class PolyInst implements Comparable<PolyInst>{
        //nX^deg <-- part of Polynomial
        double n;
        double deg;

        @Override
        public String toString() {
            return "polyInst{" +
                    "n=" + n +
                    ", deg=" + deg +
                    '}';
        }

        @Override
        public int compareTo(PolyInst o) {
            return (int) (o.deg - deg);
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
                    PolyInst t = new PolyInst();
                    t.n = coeffs[i] * right.coeffs[j];
                    t.deg = (degThis - i - 1) + (degRight - j - 1);
                    listParts.add(t);
                    //mElements.add(t);
                }

                //listParts.add(mElements);
            }
            //double[] newCoeffs = addEquals(listParts);
            return addEquals(listParts);
        }else {
            return right.multiply(this);
        }

    }

    //help methods
    private MyPolynomial addEquals(List list){
        Collections.sort(list);
        System.out.println(list);
        System.out.println("!!!!!!!!!");
        while (!checkEqDeg((ArrayList<PolyInst>) list)){
            list = add(list);
            System.out.println(" !! ---- > "+list);
        }
        System.out.println("!!!!!!!!!");



        double[] nCoeffs = new double[(int) ((PolyInst) list.get(0)).deg + 1];
        System.out.println("!! "+nCoeffs.length);

        for(PolyInst x : (ArrayList<PolyInst>) list){
            nCoeffs[(int) (nCoeffs.length - x.deg - 1)] = x.n;
        }

        return new MyPolynomial(nCoeffs);

    }

    private List add(List list){
        //add parts with equals degree
        Collections.sort(list);

        List newCoeffs = new ArrayList();
        PolyInst prev = (PolyInst) list.get(0);
        list.remove(prev);

        //System.out.println("! "+prev);
        PolyInst tPart = new PolyInst();
        tPart.n = prev.n;
        tPart.deg = prev.deg;
        for(PolyInst o : (ArrayList<PolyInst>)list){

            if(o.deg != prev.deg){
                //System.out.println("---> "+tPart);
                newCoeffs.add(tPart);
                tPart = new PolyInst();
                tPart.n = o.n;
                tPart.deg = o.deg;

            }else {
                tPart.n *= o.n;
                tPart.deg += o.deg;
            }
            //System.out.println(o);

            prev = o;
        }


        Collections.sort(newCoeffs);

        return newCoeffs;
    }

    private boolean checkEqDeg(ArrayList<PolyInst> list){

        for(int i = 1; i < list.size(); i++){
            if(list.get(i - 1).deg == list.get(i).deg) {
                return false;
            }
        }

        return true;
    }


}
