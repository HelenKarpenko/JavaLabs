package com.karpenko.cui;

import com.karpenko.vector.Vector;

public class CUI {
    public static void showDotProduct(Vector v1, Vector v2, double scalarProduct) {
        System.out.printf("Dot Product: %s * %s = %.2f\n", v1, v2, scalarProduct);
    }

    public static void showError(String message) {
        System.out.printf("Error: %s\n", message);
    }

    public static void showLength(Vector v, double length) {
        System.out.printf("Length: | %s | = %.2f\n", v, length);
    }

    public static void showSum(Vector v1, Vector v2, Vector result) {
        System.out.printf("Sum: %s + %s = %s\n", v1, v2, result);
    }

    public static void showSubtraction(Vector v1, Vector v2, Vector result) {
        System.out.printf("Subtraction: %s - %s = %s\n", v1, v2, result);
    }

    public static void showCrossProduct(Vector v1, Vector v2, Vector result) {
        System.out.printf("Cross Product: %s x %s = %s\n", v1, v2, result);
    }

    public static void showAngle(Vector v1, Vector v2, double result) {
        System.out.printf("Angle: (%s * %s) = %.2f\n", v1, v2, result);
    }

    public static void showTitle(String title) {
        System.out.println(title);
    }

    public static void showLine() {
        System.out.println("----------------------------------------------------------------------------------------");
    }
}
