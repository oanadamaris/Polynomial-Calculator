package org.example.MODEL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Polynomial {
    private Map<Integer,Monomial> poly;
    public Polynomial(HashMap poly){
        this.poly=new HashMap<>();
    }
    public Map<Integer, Monomial> getPoly() {
        return poly;
    }
    public void setPoly(Map<Integer, Monomial> poly) {
        this.poly = poly;
    }
    public void addMono(Monomial m){
        if (poly == null) {
            poly = new HashMap<>();
        }
        if(poly.containsKey(m.getExponent())) {
            Monomial newM = poly.get(m.getExponent());
            newM.setCoefficient(m.getCoefficient() + newM.getCoefficient());
            poly.put(m.getExponent(), newM);
        }
        else{
            poly.put(m.getExponent(),m);
        }
    }
    public Monomial getMono(int iterator){
        int i=0;
        for(Map.Entry<Integer, Monomial> entry: poly.entrySet()) {
            if(i==iterator){
                return entry.getValue();
            }
            else{
                i++;
            }
        }
        return null;
    }
    public void remMono(int exponent){
        Monomial m=poly.get(exponent);
        poly.remove(exponent,m);
    }
    public void negate(){
        for(Map.Entry<Integer, Monomial> entry: poly.entrySet()) {
            entry.getValue().setCoefficient(-(entry.getValue().getCoefficient()));
        }
    }
    public static Polynomial stringToPoly(String polyS) {
        HashMap<Integer, Monomial> map = new HashMap<>();
        Polynomial polynomial = new Polynomial(map);
        Pattern pattern = Pattern.compile("([+-]?\\d*\\.?\\d*)?(x)?(?:\\^(\\d+))?", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(polyS);
        while (matcher.find()) {
            double coefficient=0.0;
            int exponent;
            String coefficientStr = matcher.group(1);
            String containsX = matcher.group(2);
            String exponentStr = matcher.group(3);
            if (coefficientStr != null && !coefficientStr.isEmpty()) {
                if (coefficientStr.equals("+")) {
                    coefficient = 1.0;
                } else if (coefficientStr.equals("-")) {
                    coefficient = -1.0;
                } else {
                        coefficient = Double.parseDouble(coefficientStr);
                }
            }
            else {
                if (!(containsX == null || containsX.isEmpty())) {
                    coefficient = 1.0;
                }
            }
            if (exponentStr != null && !exponentStr.isEmpty()) {
                exponent = Integer.parseInt(exponentStr);
            }
            else{
                if(containsX==null || containsX.isEmpty()){
                    exponent=0;
                }
                else{
                    exponent=1;
                }
            }
            Monomial monomial = new Monomial(exponent, coefficient);
            if(exponent>=0 && coefficient!=0){
                polynomial.addMono(monomial);
            }
        }
        return polynomial;
    }
    @Override
    public String toString(){
        StringBuilder p=new StringBuilder();
        int countZero=0;
        if (poly == null) {
            poly = new HashMap<>();
        }
        ArrayList<Integer> exponenti=new ArrayList<>(poly.keySet());
        boolean primaI=true;
        Collections.sort(exponenti, Collections.reverseOrder());
        for(int i:exponenti){
            Monomial m=poly.get(i);
            if(m.getCoefficient()!=0){
                if(primaI){
                    primaI=false;
                    p.append(m);
                }
                else{
                    if(m.getCoefficient()<0){
                        p.append(' ').append(m);
                    }
                    else{
                        p.append(" +").append(m);
                    }
                }
            }
            else{
                countZero++;
                if(countZero== exponenti.size()-1 || countZero== exponenti.size()){
                    p.append('0');
                }
            }
        }
        if(poly.isEmpty()){
            return "0";
        }
        else{
            return p.toString();
        }
    }
}