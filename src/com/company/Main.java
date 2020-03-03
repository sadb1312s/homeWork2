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
        /*System.out.println(myComplex.subtractNew(c2));
        System.out.println(myComplex);*/

        System.out.println(myComplex.multiply(c2));
        System.out.println(myComplex.conjugate());
        System.out.println(c2.conjugate());
    }
}
