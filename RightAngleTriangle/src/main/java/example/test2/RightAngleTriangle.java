package example.test2;

import example.test.Hypotenuse;

public class RightAngleTriangle {
    private double sideA, sideB, hypotenuse;

    void setSideA(double a) {
        sideA = a;
    }

    void setSideB(double b) {
        sideB = b;
    }

    double getSideA() {
        return sideA;
    }

    double getSideB() {
        return sideB;
    }

    public double getHypotenuse() {
        return Hypotenuse.getHypotenuse(sideA, sideB);
    }

    public static void main(String[] args)
    {
        RightAngleTriangle triangle = new RightAngleTriangle();
        triangle.setSideA(3.0);
        triangle.setSideB(4.0);
        double ten = triangle.getHypotenuse();
        System.out.println("Hypotenuse is: " + ten);
    }
}
