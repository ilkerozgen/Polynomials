import java.util.Arrays;

/**
 * A class that allows to create and use polynomials.
 * @author İlker Özgen
 * @version 23.02.2021
*/
public class Polynomials
{
    // Properties
    double[] coefficients = new double[100];
    int degreeOfPolynomial;
    boolean hasSingleTerm;
    
    // Constructors
    
    /**
     * A constructor to construct polynomials of the form P(x) = cx^d.
     * @param c the coefficient of the polynomial
     * @param d the degree of the polynomial
    */
    public Polynomials( double c, int d ) 
    {
        coefficients[d] = c;
        degreeOfPolynomial = d;
        hasSingleTerm = true;
    }
    
    /**
     * A constructor to construct a zero polynomial ( P(x) = 0 ).
    */
    public Polynomials() 
    {
        coefficients[0] = 0;
        degreeOfPolynomial = 0;
    }
    
    /**
     * A constructor that takes an array of coefficients and produces a polynomial with these coefficients.
     * @param theCoefficients the array of coefficients
    */
    public Polynomials( double[] theCoefficients ) 
    {
        coefficients = Arrays.copyOf( theCoefficients, theCoefficients.length );
        degreeOfPolynomial = theCoefficients.length - 1;
    }
    
    // Methods
    
    /**
     * A getter method for a coefficient which takes degree and returns the coefficient of the term with that degree.
     * @param theDegree the degree of the term
     * @return the coefficient of the term
    */
    public double getTermCoefficient( int theDegree ) 
    {
        return coefficients[theDegree];
    }
    
    /**
     * A method that returns the degree of the polynomial.
     * @return the degree of the polynomial
    */
    public int getDegree() 
    {
        return degreeOfPolynomial;
    }
    
    /**
     * A method that returns String representation of the polynomial.
     * @return String representation of the polynomial.
    */
    public String toString() 
    {
        String result;
        result = "P(x) = ";
        
        if ( coefficients[0] != 0 ) 
        {
            result += coefficients[0];
        }
        else if ( coefficients[0] == 0 && degreeOfPolynomial == 0 )
        {
            result += coefficients[0];
        }
        
        for ( int i = 1; i <= degreeOfPolynomial; i++ ) 
        {
            if ( coefficients[i] < 0 ) 
            {
                result += " - " + Math.abs( coefficients[i] ) + "x^" + i;
            }
            else if ( coefficients[i] > 0 && !hasSingleTerm )  
            {
                result += " + " + coefficients[i] + "x^" + i;
            }
            else if ( coefficients[i] > 0 && hasSingleTerm ) 
            {
                result += coefficients[i] + "x^" + i;
            }
        }
            
            return result;
    }
    
    /**
     * A method that evaluates the polynomial at x and returns the result, using the traditional method.
     * @param x the variable of the polynomial
     * @return the result of the calculation
    */
    public double eval( double x ) 
    {
        double result;
        double termValue;
        result = coefficients[0];
        
        for ( int i = 1; i < coefficients.length; i++ ) 
        {
            termValue = coefficients[i] * Math.pow( x, i );
            result += termValue;
        }
        
        return result;
    }
    
    /**
     * A method that evaluates the polynomial at x and returns the result, using the Horner's method.
     * @param x the variable of the polynomial
     * @return the result of the calculation
    */
    public double eval2( double x ) 
    {
        double result;
        result = coefficients[degreeOfPolynomial];
        
        for (int i = degreeOfPolynomial; i > 0 ; i--) 
        {
            result = result * x + coefficients[i - 1];
        }
      
        return result;
    }   
    
    /**
     * Sums the polynomial for which the method is called and the polynomial which is the parameter.
     * @param p2 the polynomial to be summed with the main one
     * @return the sum of two polynomials as a new polynomial
    */
    public Polynomials add( Polynomials p2 ) 
    {
        Polynomials newPolynomial;
        newPolynomial = new Polynomials();
        
        for (int i = 0; i < coefficients.length; i++) 
        {
            newPolynomial.coefficients[i] = coefficients[i];
        }
        
        for (int i = 0; i < p2.coefficients.length; i++) 
        {
            newPolynomial.coefficients[i] = newPolynomial.coefficients[i] + p2.coefficients[i];
        }
        
        newPolynomial.degreeOfPolynomial = Math.max(degreeOfPolynomial, p2.getDegree());
        
        return newPolynomial;
    }
    
    /**
     * Subtracts the parameter polynomial from the polynomial for which the method is called on. 
     * @param p2 the polynomial to be substracted from the main one
     * @return the result of the substraction as a new polynomial
    */
    public Polynomials sub( Polynomials p2 ) 
    {
        Polynomials newPolynomial;
        newPolynomial = new Polynomials();
        
        for (int i = 0; i < coefficients.length; i++) 
        {
            newPolynomial.coefficients[i] = coefficients[i];
        }
        
        for (int i = 0; i < p2.coefficients.length; i++) 
        {
            newPolynomial.coefficients[i] = newPolynomial.coefficients[i] - p2.coefficients[i];
        }
        
        newPolynomial.degreeOfPolynomial = Math.max(degreeOfPolynomial, p2.getDegree());
        
        return newPolynomial;
    }
    
    /**
     * Multiplies this polynomial for which the method is called and the parameter polynomial.
     * @param p2 the polynomial to be multiplied with the main one
     * @return the result of the multiplication as a new polynomial
    */
    public Polynomials mul(Polynomials p2 ) 
    {
        Polynomials newPolynomial;
        newPolynomial = new Polynomials();
        
        for (int i = 0; i < coefficients.length; i++) 
        {
            for (int j = 0; j < p2.coefficients.length; j++) 
            {
                if ( i + j < 100 ) 
                {
                    newPolynomial.coefficients[i + j] += coefficients[i] * p2.coefficients[j];
                }
            }
        }
        
        newPolynomial.degreeOfPolynomial = degreeOfPolynomial + p2.getDegree();
        
        return newPolynomial;
    }
    
    /**
     * Composes the main polynomial with the parameter polynomial.
     * @param p2 the polynomial to be composed with the main one
     * @return the result of the composition as a new polynomial
    */
    public Polynomials compose( Polynomials p2 ) 
    {
        Polynomials currentPolynomial = this;
        Polynomials newPolynomial = new Polynomials( 0, 0 );
        
        for( int i = currentPolynomial.getDegree(); i >= 0; i-- )
        {
            Polynomials term = new Polynomials( currentPolynomial.coefficients[ i ], 0 );
            newPolynomial = term.add( p2.mul( newPolynomial ) );
        }
        return newPolynomial;
    }
    
    /**
     * Divides the main polynomial with the parameter polynomial.
     * @param p2 the denominator polynomial
     * @return the quotient of the division
    */
    public Polynomials div( Polynomials p2 ) 
    {
        Polynomials px;
        Polynomials qx;
        Polynomials tx;
        Polynomials leadPx;
        Polynomials leadQx;
        Polynomials result;
        double coefficient;
        int degree;
        px = this;
        qx = p2;
        result = new Polynomials();
                
        while ( px.getDegree() >= qx.getDegree() ) 
        {
            // Find the leading term (non zero term with highest degree) of the P(x) and Q(x).
            leadPx = new Polynomials( px.coefficients[px.getDegree()], px.getDegree() );
            leadQx = new Polynomials ( qx.coefficients[qx.getDegree()], qx.getDegree() );
            
            // Find polynomial T(x) such that: T(x) = lead(P(x)) / lead(Q(x)).
            coefficient = leadPx.coefficients[px.getDegree()] / leadQx.coefficients[qx.getDegree()];
            degree = leadPx.getDegree() - leadQx.getDegree();   
            tx = new Polynomials( coefficient, degree );
            
            // Substract T(x) * Q(x) from P(x) and assign the result to P(x).
            px = px.sub( tx.mul( qx ) );
            
            // Add T(x) to the result.
            result = result.add(tx);
            
            // Decrease the degree of P(x) by 1.
            px.degreeOfPolynomial--;
        }
        
        return result;
    }
    
}
