package com.karpenko.vector;

import java.util.Arrays;

    public class Vector implements Cloneable {
    private int[] coordinates;
    private int dimension;

    public Vector(int[] coordinates) {
        if (coordinates == null)
            throw new IllegalArgumentException("Coordinates must not be null.");
        this.coordinates = coordinates;
        dimension = coordinates.length;
    }

    public Vector(int value, int dimension) throws VectorException {
        this(dimension);
        Arrays.fill(coordinates, value);
    }

    public Vector(int dimension) throws VectorException {
        if (dimension <= 0)
            throw new VectorException("Dimension must be greater than zero.");

        this.coordinates = new int[dimension];
        this.dimension = dimension;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public int getDimension() {
        return dimension;
    }

    public int getCoordinate(int position) {
        if (position < 0)
            throw new IllegalArgumentException("Incorrect position. Position must be greater than zero");

        if (position >= dimension)
            throw new IllegalArgumentException("Incorrect position. Position must be less than the dimension");

        return coordinates[position];
    }

    public void setCoordinate(int position, int value) {
        if (position < 0)
            throw new IllegalArgumentException("Incorrect position. Position must be greater than zero");

        if (position >= dimension)
            throw new IllegalArgumentException("Incorrect position. Position must be less than the dimension");

        coordinates[position] = value;
    }

    public Vector add(Vector vector) throws VectorException {
        if (vector == null)
            throw new IllegalArgumentException("Vector must not be null.");

        if (vector.dimension != dimension)
            throw new VectorException(String.format("Vector1 = %s and vector2 = %s have different dimensions.", this, vector));

        Vector newVector = new Vector(dimension);

        for (int i = 0; i < dimension; i++) {
            newVector.coordinates[i] = coordinates[i] + vector.coordinates[i];
        }
        return newVector;
    }

    public Vector sub(Vector vector) throws VectorException {
        if (vector == null)
            throw new IllegalArgumentException("Vector must not be null.");

        if (vector.dimension != dimension)
            throw new VectorException(String.format("Vector1 = %s and vector2 = %s have different dimensions.", this, vector));

        Vector newVector = new Vector(dimension);

        for (int i = 0; i < dimension; i++) {
            newVector.coordinates[i] = coordinates[i] - vector.coordinates[i];
        }
        return newVector;
    }

    public Vector crossProduct(Vector vector) throws VectorException {
        if (vector == null)
            throw new IllegalArgumentException("Vector must not be null.");

        if (dimension != 3 || vector.dimension != 3)
            throw new VectorException(String.format("We can multiply only vectors of dimension 3. Vector1 = %s and vector2 = %s", this, vector));

        Vector newVector = new Vector(dimension);

        int x1 = coordinates[0];
        int y1 = coordinates[1];
        int z1 = coordinates[2];

        int x2 = vector.coordinates[0];
        int y2 = vector.coordinates[1];
        int z2 = vector.coordinates[2];

        newVector.coordinates[0] = (y1 * z2) - (z1 * y2);
        newVector.coordinates[1] = (z1 * x2) - (x1 * z2);
        newVector.coordinates[2] = (x1 * y2) - (y1 * x2);

        return newVector;
    }

    public Vector increment() throws VectorException {
        Vector vectorForIncrement = new Vector(1, dimension);
        return add(vectorForIncrement);
    }

    public Vector decrement() throws VectorException {
        Vector vectorForDecrement = new Vector(1, dimension);
        return sub(vectorForDecrement);
    }

    public double length() {
        double result = 0;

        for (int i = 0; i < dimension; i++) {
            result += Math.pow(coordinates[i], 2);
        }

        result = Math.sqrt(result);

        return result;
    }

    public double dotProduct(Vector vector) throws VectorException {
        if (vector == null)
            throw new IllegalArgumentException("Vector must not be null.");

        if (vector.dimension != dimension)
            throw new VectorException(String.format("Vector1 = %s and vector2 = %s have different dimensions.", this, vector));

        double result = 0;
        for (int i = 0; i < dimension; i++) {
            result += coordinates[i] * vector.coordinates[i];
        }

        return result;
    }

    public double getAngle(Vector vector) throws VectorException {
        if (vector == null)
            throw new IllegalArgumentException("Vector must not be null.");

        if (vector.dimension != dimension)
            throw new VectorException(String.format("Vector1 = %s and vector2 = %s have different dimensions.", this, vector));

        double cos = this.dotProduct(vector) / (this.length() * vector.length());

        if (Math.abs(cos) > 1) cos = Math.signum(cos);

        return Math.acos(cos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Vector vector = (Vector) obj;
        if (dimension != vector.dimension) return false;

        for (int i = 0; i < dimension; i++) {
            if (coordinates[i] != vector.coordinates[i])
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 17 + dimension;
        for (int i = 0; i < dimension; i++) {
            hash = hash * 31 + coordinates[i];
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("[");
        for (int i = 0; i < dimension; i++) {
            strBuilder.append(String.format(" %d ", coordinates[i]));
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vector cloneObj = (Vector) super.clone();
        cloneObj.coordinates = this.coordinates.clone();
        return cloneObj;
    }
}
