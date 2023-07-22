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

    public double getArea()
    {
        return 0.5 * sideA * sideB;
    }

    public static void main(String[] args) throws IllegalArgumentException
    {
        System.out.print("Enter height h: ");
        Double h = Double.parseDouble(System.console().readLine());

        System.out.print("Enter base b: ");
        Double b = Double.parseDouble(System.console().readLine());

        if (b > h) {
            throw new IllegalArgumentException("Base can not be greater than the height!");
        }

        RightAngleTriangle triangle = new RightAngleTriangle(h, b);
        System.out.println("Hypotenuse is: " + triangle.getHypotenuse());
        System.out.println("Area is: " + triangle.getArea());
    }
}
