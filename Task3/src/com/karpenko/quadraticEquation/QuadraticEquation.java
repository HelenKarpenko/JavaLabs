package com.karpenko.quadraticEquation;

public class QuadraticEquation {
//    Определить класс «Квадратное уравнение». Использовать  try/catch,  если уравнение не имеет решения. Создать массив объектов и выполнить вычисления.
    private int a;
    private int b;
    private int c;

    public QuadraticEquation(int a, int b, int c) {
        if (a == 0)
            throw new IllegalArgumentException("Incorrect coefficient a");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }

    public double[] getRoots() throws QuadraticEquationException {
        double discriminant = getDiscriminant();

        if (discriminant < 0) {
            throw new QuadraticEquationException("Discriminant is negative, then there are no real roots.");
        }

        if (discriminant == 0) {
            double root = (- b) / (2 * a);
            return new double[] { root };
        }

        if (discriminant > 0) {
            double root1 = ((- b) + Math.sqrt(discriminant)) / (2 * a);
            double root2 = ((- b) - Math.sqrt(discriminant)) / (2 * a);
            return new double[] { root1, root2 };
        }

        return null; //Missing return statement
    }

    private double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash += 31 * a;
        hash += 31 * b;
        hash += 31 * c;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        QuadraticEquation qe = (QuadraticEquation) obj;
        if (a != qe.a) return false;
        if (b != qe.b) return false;
        if (c != qe.c) return false;

        return true;
    }

    @Override
    public String toString() {
        return String.format("%dx^2 + %dx + %d = 0", a, b, c);
    }
}
