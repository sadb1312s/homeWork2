package com.company;

public class Main {

    public static void main(String[] args) {
        MyComplex myComplex = new MyComplex(5,-3);
        System.out.println(myComplex);

        MyComplex c2 = new MyComplex(4,-7);
        System.out.println(myComplex.equals(c2));
        System.out.println(myComplex.magnitude());
        System.out.println(myComplex.argument());
        //add/subtract....
        System.out.println("add/subtract....");
        System.out.println(myComplex.subtractNew(c2));
        System.out.println(myComplex);

        System.out.println(myComplex.multiply(c2));
        System.out.println(myComplex.conjugate());
        System.out.println(c2.conjugate());

        //Polynomial
        System.out.println("-- Polynomial --");
        double[] c = {5,7,3,8,123};
        double[] c3 = {4,3,7};
        //add
        MyPolynomial polynomial = new MyPolynomial(c);
        System.out.println(polynomial.getDegree());
        System.out.println(polynomial);
        System.out.println(polynomial.evaluate(3));

        MyPolynomial polynomial2 = new MyPolynomial(c3);
        System.out.println(polynomial2);
        System.out.println(polynomial.add(polynomial2));
        System.out.println(polynomial);
        System.out.println(polynomial2);
        //multiply
        System.out.println("-- Polynomial multiply --");
        System.out.println(polynomial);
        System.out.println(polynomial2);
        polynomial.multiply(polynomial2);

    }
}
