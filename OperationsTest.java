import org.example.LOGIC.Operations;
import org.example.MODEL.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    Operations o=new Operations();
    Polynomial p=Polynomial.stringToPoly("3.0x^2 +3.0x");
    Polynomial q=Polynomial.stringToPoly("5.0x^3 +3.0x^2");
    @Test
    public void addTest1(){
        assertEquals("5.0x^3 +6.0x^2 +3.0x",o.add(p,q).toString());
    }
    @Test
    public void addTest2(){
        assertEquals("5.0x^3",o.add(p,q).toString());
    }
    @Test
    public void substractTest1(){
        assertEquals("-5.0x^3 +3.0x",o.substract(p,q).toString());
    }
    @Test
    public void substractTest2(){
        assertEquals("5.0x^3 +3.0x",o.substract(p,q).toString());
    }
    @Test
    public void multiplyTest1(){
        assertEquals("15.0x^5 +24.0x^4 +9.0x^3",o.multiply(p,q).toString());
    }
    @Test
    public void multiplyTest2(){
        assertEquals("24.0x^4 +9.0x^3",o.multiply(p,q).toString());
    }
    @Test
    public void divideTest1(){
        p=Polynomial.stringToPoly("x^3 -2x^2 +6x -5");
        q=Polynomial.stringToPoly("x^2 -1");
        assertEquals("Quotient:x -2.0     Remainder:7.0x -7.0",o.divide(p,q));
    }
    @Test
    public void divideTest2(){
        p=Polynomial.stringToPoly("x^3 -2x^2 +6x -5");
        q=Polynomial.stringToPoly("0");
        assertEquals("Quotient:x -2.0     Remainder:7.0x -7.0",o.divide(p,q));
    }
    @Test
    public void derivateTest1(){
        assertEquals("6.0x +3.0",o.derivate(p).toString());
    }
    @Test
    public void derivateTest2(){
        assertEquals("9.0x",o.derivate(p).toString());
    }
    @Test
    public void integrateTest1(){
        assertEquals("x^3 +1.5x^2",o.integrate(p).toString());
    }
    @Test
    public void integrateTest2(){
        assertEquals("x",o.integrate(p).toString());
    }
}