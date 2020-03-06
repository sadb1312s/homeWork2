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
        /*double[] c = {3,2,0,0,0,0,5};
        double[] c3 = {4,1,5};*/
        double[] c = {2,0,0,0,0,4,3,0};
        double[] c3 = {3,0,0,0,0,2,0,15,0};
        //add
        MyPolynomial polynomial = new MyPolynomial(c);
        System.out.println(polynomial.getDegree());
        System.out.println(polynomial);
        System.out.println(polynomial.evaluate(3));


        MyPolynomial polynomial2 = new MyPolynomial(c3);
        //multiply
        System.out.println("-- Polynomial add --");
        System.out.println(polynomial);
        System.out.println(polynomial2);
        System.out.println(" answer "+polynomial.add(polynomial2));

        //multiply
        System.out.println("-- Polynomial multiply --");
        System.out.println(polynomial);
        System.out.println(polynomial2);
        System.out.println(" answer "+polynomial.multiply(polynomial2));

        //Ball
        System.out.println("-- Ball --");
        Ball ball = new Ball(50,50,10,100,45);
        System.out.println(ball);

        Container container = new Container(0,100,100,100);
        System.out.println(container);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println(container.collides(ball));


    }
}
