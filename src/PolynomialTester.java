/**
 * A program to test polynomials class. 
 * @author İlker Özgen
 * @version 23.02.2021
*/ 
public class PolynomialTester
{
    public static void main(String[] args)
    {   
        // Variables
        double[] coefficients1 = { 3, 4, 1, 3, 0, 2};
        double[] coefficients2 = { 2, 1 };
        
        // 1. Create a polynomial with a single term.
        Polynomials polynomial1 = new Polynomials( 3, 4 );
        
        // 2. Create a zero polynomial.
        Polynomials polynomial2 = new Polynomials();
        
        // 3. Create other polynomials.
        Polynomials polynomial3 = new Polynomials( coefficients1 );
        Polynomials polynomial4 = new Polynomials( coefficients2 );
        
        // 4. Print the polynomials.
        System.out.println( "=========================================================" );
        System.out.println( "Polynomial 1: " + polynomial1 );
        System.out.println( "Polynomial 2: " + polynomial2 );
        System.out.println( "Polynomial 3: " + polynomial3 );
        System.out.println( "=========================================================" );
        
        // 5. Get the certains terms' coefficients.
        System.out.println( "The coefficient of the term with degree 4 (polynomial 1): " + polynomial1.getTermCoefficient( 4 ) );
        System.out.println( "The coefficient of the term with degree 0 (polynomial 2): " + polynomial2.getTermCoefficient( 0 ) );
        System.out.println( "The coefficient of the term with degree 1 (polynomial 3): " + polynomial3.getTermCoefficient( 1 ) );
        System.out.println( "The coefficient of the term with degree 2 (polynomial 3): " + polynomial3.getTermCoefficient( 2 ) );
        System.out.println( "=========================================================" );
        
        // 6. Get the degrees of the polynomials.
        System.out.println( "The degree of polynomial 1: " + polynomial1.getDegree() );
        System.out.println( "The degree of polynomial 2: " + polynomial2.getDegree() );
        System.out.println( "The degree of polynomial 3: " + polynomial3.getDegree() );
        System.out.println( "=========================================================" );
        
        // 7. Evaluate the polynomials using the traditional method.
        System.out.println( "Calculated by using the traditional method:" );
        System.out.println( "The value of polynomial 1 at x = 3 --> P(3) = " + polynomial1.eval( 3 ) );
        System.out.println( "The value of polynomial 2 at x = 2 --> P(2) = " + polynomial2.eval( 2 ) );
        System.out.println( "The value of polynomial 3 at x = 1 --> P(1) = " + polynomial3.eval( 1 ) );
        System.out.println( "The value of polynomial 3 at x = 2 --> P(3) = " + polynomial3.eval( 2 ) );
        System.out.println( "=========================================================" );
        
        // 8. Evaluate the polynomials using the Horner’s method.
        System.out.println( "Calculated by using Horner's method:" );
        System.out.println( "The value of polynomial 1 at x = 3 --> P(3) = " + polynomial1.eval2( 3 ) );
        System.out.println( "The value of polynomial 2 at x = 2 --> P(2) = " + polynomial2.eval2( 2 ) );
        System.out.println( "The value of polynomial 3 at x = 1 --> P(1) = " + polynomial3.eval2( 1 ) );
        System.out.println( "The value of polynomial 3 at x = 2 --> P(3) = " + polynomial3.eval2( 2 ) );
        System.out.println( "=========================================================" );
        
        // 9. Compute the sum of polynomial 3 and polynomial 4.
        System.out.println( "The sum of polynomials: " + polynomial3.add(polynomial4) );
        System.out.println( "=========================================================" );
        
        // 10. The result of substraction of polynomial 4 from polynomial 3.
        System.out.println( "The substraction of polynomials: " + polynomial3.sub(polynomial4) );
        System.out.println( "=========================================================" );
        
        // 11. The multiplication of polynomial 3 and polynomial 4.
        System.out.println( "The multiplication of polynomials: " + polynomial3.mul(polynomial4) );
        System.out.println( "=========================================================" );
        
        // 12. The composition of polynomial 3 and polynomial 4.
        System.out.println( "The composition of polynomials: " + polynomial3.compose(polynomial4) );
        System.out.println( "=========================================================" );
        
        // 13. The division of polynomial 3 by polynomial 4.
        System.out.println( "The quotient of the division of polynomials: " + polynomial3.div(polynomial4) );
        System.out.println( "=========================================================" );
        
    }
    
}