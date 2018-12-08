package com.karpenko.main;

import com.karpenko.cui.CUI;
import com.karpenko.quadraticEquation.QuadraticEquation;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<QuadraticEquation> equations = new LinkedList<>();
        equations.add(new QuadraticEquation(1,-8,12));
        equations.add(new QuadraticEquation(5,3,7));
        equations.add(new QuadraticEquation(1,-6,9));
        equations.add(new QuadraticEquation(1,1,1));

        for (QuadraticEquation eq : equations) {
            CUI.showEquation(eq);
            try {
                double[] roots = eq.getRoots();
                CUI.showRoots(roots);
            } catch (Exception ex) {
                CUI.showError(ex.getMessage());
            }

        }
    }

}
