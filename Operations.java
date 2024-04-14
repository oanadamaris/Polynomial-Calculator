package org.example.LOGIC;
import org.example.MODEL.Monomial;
import org.example.MODEL.Polynomial;
import java.util.HashMap;
import java.util.Map;
public class Operations {
    public Polynomial add(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Monomial>map=new HashMap<>();
        Polynomial result=new Polynomial(map);
        for(Map.Entry<Integer, Monomial> entry: p1.getPoly().entrySet()) {
            result.addMono(entry.getValue());
        }
        double newCoeff=0;
        for(Map.Entry<Integer, Monomial> entry: p2.getPoly().entrySet()){
            if(result.getPoly().containsKey(entry.getKey())){
                newCoeff=result.getPoly().get(entry.getKey()).getCoefficient()+entry.getValue().getCoefficient();
                if(newCoeff!=0){
                    result.remMono(entry.getKey());
                    result.addMono(new Monomial(entry.getValue().getExponent(),newCoeff));
                }
                else{
                    result.remMono(entry.getKey());
                    if(result.getPoly().isEmpty()){
                        result=Polynomial.stringToPoly("0");
                    }
                }
            }
            else{
                result.addMono(entry.getValue());
            }
        }
        return result;
    }
    public Polynomial substract(Polynomial p1, Polynomial p2) {
        p2.negate();
        return add(p1,p2);
    }
    public Polynomial multiply(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Monomial> map1 = new HashMap<>();
        Polynomial result = new Polynomial(map1);
        HashMap<Integer, Monomial> map2 = new HashMap<>();
        double newCoeff=0.0;
        int newExponent=0;
        for(Map.Entry<Integer, Monomial> entry1: p1.getPoly().entrySet()) {
            for (Map.Entry<Integer, Monomial> entry2 : p2.getPoly().entrySet()) {
                newCoeff =entry1.getValue().getCoefficient()*entry2.getValue().getCoefficient();
                newExponent =entry1.getValue().getExponent()+entry2.getValue().getExponent();
                Monomial newMono=new Monomial(newExponent,newCoeff);
                result.addMono(newMono);
            }
        }
        return result;
    }
    public String divide(Polynomial p1, Polynomial p2) {
        StringBuilder p=new StringBuilder();
        HashMap<Integer,Monomial>map1=new HashMap<>();
        HashMap<Integer,Monomial>map2=new HashMap<>();
        Polynomial quotient=new Polynomial(new HashMap<>(map1));
        Operations o=new Operations();
        p1=Polynomial.stringToPoly(p1.toString());
        p2=Polynomial.stringToPoly(p2.toString());
        Polynomial remainder=p1;
        if(p2.toString().equals("0")){
            p=p.append("Can't divide by 0");
            return p.toString();
        }
        if(p1.getMono(p1.getPoly().size()-1).getExponent()>=p2.getMono(p2.getPoly().size()-1).getExponent()){
            while(remainder.getMono(remainder.getPoly().size()-1).getExponent()>=p2.getMono(p2.getPoly().size()-1).getExponent())
            {
                quotient.addMono(remainder.getMono(remainder.getPoly().size()-1).division(p2.getMono(p2.getPoly().size()-1)));
                Polynomial lastPQuotient=Polynomial.stringToPoly(quotient.getMono(0).toString());
                Polynomial product=o.multiply(lastPQuotient,p2);
                remainder=(o.substract(remainder,product));
                if(remainder.getPoly().isEmpty()){
                    p.append("Quotient:").append(quotient.toString()).append("     Remainder:").append(remainder.toString());
                     return p.toString();
                }
            }
        }else{
            p.append("Second polynomial's degree is greater.\n");
        }
        p.append("Quotient:").append(quotient.toString()).append("     Remainder:").append(remainder.toString());
        return p.toString();
    }
    public Polynomial derivate(Polynomial p1){
        HashMap<Integer, Monomial> map1 = new HashMap<>();
        Polynomial result = new Polynomial(map1);
        for(Map.Entry<Integer, Monomial> entry: p1.getPoly().entrySet()){
            double coefficient=entry.getValue().getCoefficient();
            int exponent=entry.getValue().getExponent();
            entry.getValue().setCoefficient(coefficient*exponent);
            entry.getValue().setExponent(exponent-1);
            result.addMono(entry.getValue());
        }
        return result;
    }
    public Polynomial integrate(Polynomial p1){
        HashMap<Integer, Monomial> map1 = new HashMap<>();
        Polynomial result = new Polynomial(map1);
        for(Map.Entry<Integer, Monomial> entry: p1.getPoly().entrySet()){
            double coefficient=entry.getValue().getCoefficient();
            int exponent=entry.getValue().getExponent();
            entry.getValue().setCoefficient(coefficient/(exponent+1));
            entry.getValue().setExponent(exponent+1);
            result.addMono(entry.getValue());
        }
        return result;
    }
}