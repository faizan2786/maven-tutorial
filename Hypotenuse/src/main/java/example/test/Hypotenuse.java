package example.test;

import java.security.InvalidParameterException;

public class Hypotenuse {

    public static double getHypotenuse(double a, double b) throws InvalidParameterException
    {
        if (a <= 0 || b <= 0) {
            throw new InvalidParameterException("Triangle sides can not be 0 or less!");
        }
        return Math.pow(a*a + b*b, 0.5);
    }
}
