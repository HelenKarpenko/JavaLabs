package com.karpenko.cui;

import com.karpenko.quadraticEquation.QuadraticEquation;

public class CUI {
    public static void showError(String message) {
        System.out.printf("Error: %s\n", message);
    }

    public static void showEquation(QuadraticEquation equation) {
        System.out.println(equation);
    }
    public static void showRoots(double[] roots) {
        System.out.print("Roots: ");
        for(double root : roots) {
            System.out.printf("%.2f ", root);
        }
        System.out.println();
    }
}
