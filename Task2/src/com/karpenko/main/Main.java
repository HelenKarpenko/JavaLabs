package com.karpenko.main;

import com.karpenko.cui.CUI;
import com.karpenko.vector.Vector;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Vector> vectors = getFilledVectorsList();

        CUI.showLine();
        CUI.showTitle("Dot Product");
        CUI.showLine();

        for (Vector vector : vectors) {
            for (Vector vector1 : vectors) {
                try {
                    double result = vector.dotProduct(vector1);
                    CUI.showDotProduct(vector, vector1, result);
                } catch (Exception ex) {
                    CUI.showError(ex.getMessage());
                }
            }
        }

        CUI.showLine();
        CUI.showTitle("Length");
        CUI.showLine();

        for (Vector vector : vectors) {
            double result = vector.length();
            CUI.showLength(vector, result);
        }

        CUI.showLine();
        CUI.showTitle("Sum");
        CUI.showLine();

        for (Vector vector : vectors) {
            for (Vector vector1 : vectors) {
                try {
                    Vector result = vector.add(vector1);
                    CUI.showSum(vector, vector1, result);
                } catch (Exception ex) {
                    CUI.showError(ex.getMessage());
                }
            }
        }

        CUI.showLine();
        CUI.showTitle("Subtraction");
        CUI.showLine();

        for (Vector vector : vectors) {
            for (Vector vector1 : vectors) {
                try {
                    Vector result = vector.sub(vector1);
                    CUI.showSubtraction(vector, vector1, result);
                } catch (Exception ex) {
                    CUI.showError(ex.getMessage());
                }
            }
        }

        CUI.showLine();
        CUI.showTitle("Cross Product");
        CUI.showLine();

        for (Vector vector : vectors) {
            for (Vector vector1 : vectors) {
                try {
                    Vector result = vector.crossProduct(vector1);
                    CUI.showCrossProduct(vector, vector1, result);
                } catch (Exception ex) {
                    CUI.showError(ex.getMessage());
                }
            }
        }

        CUI.showLine();
        CUI.showTitle("Get Angle");
        CUI.showLine();

        for (Vector vector : vectors) {
            for (Vector vector1 : vectors) {
                try {
                    double result = vector.getAngle(vector1);
                    CUI.showAngle(vector, vector1, result);
                } catch (Exception ex) {
                    CUI.showError(ex.getMessage());
                }
            }
        }
    }

    private static List<Vector> getFilledVectorsList() throws CloneNotSupportedException {
        List<Vector> vectors = new LinkedList<>();

        vectors.add(new Vector(new int[]{1, 1, 1}));
        vectors.add(new Vector(new int[]{2, 2, 2}));
        vectors.add(new Vector(new int[]{5, 5, 5, 5}));
        var v1 = new Vector(new int[]{1,2,3});
        var v2 = v1.clone();
        v1.setCoordinate(2,10);
        System.out.println(v1+" "+v2);
        return vectors;
    }
}
