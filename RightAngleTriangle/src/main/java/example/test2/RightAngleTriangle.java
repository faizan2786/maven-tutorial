package example.test2;

import example.test.Hypotenuse;

public class RightAngleTriangle {
    private double sideA, sideB;

    public RightAngleTriangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

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
        RightAngleTriangle triangle = new RightAngleTriangle(3.0, 4.0);
        double ten = triangle.getHypotenuse();
        System.out.println("Hypotenuse is: " + ten);
    }
}
