package org.example.MODEL;

public class Monomial {
    private int exponent;
    private double coefficient;
    public Monomial(int exponent, double coefficient){
        this.exponent=exponent;
        this.coefficient=coefficient;
    }
    public Monomial division(Monomial m){
        Monomial result=new Monomial(0,0.0);
        result.setCoefficient((this.coefficient)/(m.getCoefficient()));
        result.setExponent(this.exponent-m.getExponent());
        return result;
    }
    public int getExponent() {
        return exponent;
    }
    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
    public double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public String toString(){
        if(exponent==0){
            return Double.toString(coefficient);
        }
        else{
            if(exponent==1){
                if(coefficient!=1){
                    return Double.toString(coefficient)+'x';
                }
                else{
                    return "x";
                }
            }
            else{
                if(coefficient!=1){
                    return Double.toString(coefficient)+"x^"+Integer.toString(exponent);
                }
                else{
                    return "x^"+Integer.toString(exponent);
                }
            }
        }
    }
}
