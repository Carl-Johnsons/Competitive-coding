/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab02;

/**
 *
 * @author Nguyen Le Tai Duc MSSV: CE170499
 */
public class Fraction {

    private int numberator;
    private int denominator;

    //Exercise a: Create 3 constructors
    public Fraction() {
        this.numberator = 0;
        this.denominator = 1;
    }

    public Fraction(int numberator) {
        this.numberator = numberator;
        this.denominator = 1;
    }

    public Fraction(int numberator, int denominator) {
        this.numberator = numberator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.printf("Error: the denominator can not be 0 (%d/0). Auto set the denominator to 1!! (%d/1)\n", this.numberator, this.numberator);
        }

    }
    //Exercise b: Create set and get method

    public void setFraction(int numberator, int denominator) {
        this.numberator = numberator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.printf("Error: the denominator can not be 0 (%d/0). Auto set the denominator to 1!! (%d/1)\n", this.numberator, this.numberator);
            this.denominator = 1;
        }
    }

    public void setNumberator(int numberator) {
        this.numberator = numberator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            System.out.printf("Error: The denominator can not be 0 (%d/0). Leave the Fraction unchanged!! (%d/%d) \n", this.numberator, this.numberator, this.denominator);
        } else {
            this.denominator = denominator;
        }
    }

    public Fraction getFraction() {
        Fraction a = new Fraction(this.numberator, this.denominator);
        return a;
    }

    public int getNumberator() {
        return this.numberator;
    }

    public int getDenominator() {
        return this.denominator;
    }
    //Exercise c: Create ToString method

    public String ToString() {
        return this.numberator + "/" + this.denominator;
    }
    //Exercise d: Create 2 add Fraction

    public Fraction addFraction(Fraction a) {
        int sumNumberator = this.numberator * a.denominator + a.numberator * this.denominator;
        int sumDenominator = this.denominator * a.denominator;
        int g = gcd(sumNumberator, sumDenominator);
        Fraction sum = new Fraction(sumNumberator / g, sumDenominator / g);
        return sum;
    }
    //Exercise e: Create 2 subtraction Fraction

    public Fraction addFraction(int a) {
        int sumNumberator = this.numberator + a * this.denominator;
        int g = gcd(sumNumberator, this.denominator);
        Fraction sum = new Fraction(sumNumberator / g, this.denominator / g);
        return sum;
    }

    public Fraction subFraction(Fraction a) {
        int subNumberator = this.numberator * a.denominator - a.numberator * this.denominator;
        int subDenominator = this.denominator * a.denominator;
        int g = gcd(subNumberator, subDenominator);
        Fraction sub = new Fraction(subNumberator / g, subDenominator / g);
        return sub;
    }

    public Fraction subFraction(int a) {
        int subNumberator = this.numberator - a * this.denominator;
        int g = gcd(subNumberator, this.denominator);
        Fraction sub = new Fraction(subNumberator / g, this.denominator / g);
        return sub;
    }
    //Exercise f: Create 2 multiply Fraction

    public Fraction mulFraction(Fraction a) {
        int mulNumberator = this.numberator * a.numberator;
        int mulDenominator = this.denominator * a.denominator;
        int g = gcd(mulNumberator, mulDenominator);
        Fraction mul = new Fraction(mulNumberator / g, mulDenominator / g);
        return mul;
    }

    public Fraction mulFraction(int a) {
        int mulNumberator = this.numberator * a;
        int g = gcd(mulNumberator, this.denominator);
        Fraction mul = new Fraction(mulNumberator / g, this.denominator / g);
        return mul;
    }
    //Exercise g: Create 2 divide Fraction

    public Fraction divFraction(Fraction a) {
        int temp = a.numberator;
        a.numberator = a.denominator;
        a.denominator = temp;
        Fraction present = new Fraction(this.numberator, this.denominator);
        Fraction div = present.mulFraction(a);
        int g = gcd(div.numberator, div.denominator);
        Fraction result = new Fraction(div.numberator / g, div.denominator / g);
        return result;
    }

    public Fraction divFraction(int a) {
        Fraction parameter = new Fraction(1, a);
        Fraction present = new Fraction(this.numberator, this.denominator);
        Fraction div = present.mulFraction(parameter);
        int g = gcd(div.numberator, div.denominator);
        Fraction result = new Fraction(div.numberator / g, div.denominator / g);
        return result;
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
