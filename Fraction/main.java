/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
/* fack u */
package Lab02;

/**
 *
 * @author Nguyen Le Tai Duc MSSV: CE170499
 */
public class main {

    public static void main(String[] args) {
        //Declare 4 Fraction
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction(-4);
        Fraction frac3 = new Fraction(21, 14);
        //get method
        Fraction frac4 = frac2.getFraction();
        Fraction frac5 = new Fraction(5, 0);
        int NU = frac2.getNumberator();
        int DE = frac2.getDenominator();
        System.out.println("frac2 before set: " + NU + "/" + DE);
        //set method
        frac2.setFraction(-4, 7);
        frac1.setNumberator(2);
        frac1.setDenominator(0);
        frac5.setFraction(7, 0);
        //Print all the current Fractions
        int INTA = 5;
        System.out.println("frac1: " + frac1.ToString());
        System.out.println("frac2: " + frac2.ToString());
        System.out.println("frac3: " + frac3.ToString());
        System.out.println("frac4: " + frac4.ToString());
        System.out.println("frac5: " + frac5.ToString());
        System.out.println("--------------------------------------------------------------");
        System.out.println("4 Fraction to Fraction:");
        System.out.println(frac2.ToString() + " + " + frac3.ToString() + " = " + (frac2.addFraction(frac3).ToString()));
        System.out.println(frac2.ToString() + " - " + frac3.ToString() + " = " + (frac2.subFraction(frac3).ToString()));
        System.out.println(frac2.ToString() + " * " + frac3.ToString() + " = " + (frac2.mulFraction(frac3).ToString()));
        System.out.println(frac2.ToString() + " / " + frac3.ToString() + " = " + (frac2.divFraction(frac3).ToString()));
        System.out.println("--------------------------------------------------------------");
        System.out.println("4 Fraction to Int:");
        System.out.println(frac4.ToString() + " + " + INTA + " = " + (frac4.addFraction(INTA).ToString()));
        System.out.println(frac4.ToString() + " - " + INTA + " = " + (frac4.subFraction(INTA).ToString()));
        System.out.println(frac4.ToString() + " * " + INTA + " = " + (frac4.mulFraction(INTA).ToString()));
        System.out.println(frac4.ToString() + " / " + INTA + " = " + (frac4.divFraction(INTA).ToString()));
    }
}
