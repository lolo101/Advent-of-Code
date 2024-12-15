package fr.lbroquet.adventofcode2024.day13;

record Matrix(Vector e1, Vector e2, Ratio determinant) {

    Matrix(Vector e1, Vector e2) {
        this(e1, e2, e1.x().multiply(e2.y()).subtract(e2.x().multiply(e1.y())));
    }

    boolean invertible() {
        return determinant.isNotZero();
    }

    Matrix inverse() {
        Vector e1inverse = new Vector(e2.y(), e1.y().negate()).divided(determinant);
        Vector e2inverse = new Vector(e2.x().negate(), e1.x()).divided(determinant);
        return new Matrix(e1inverse, e2inverse);
    }

    Vector multiply(Vector vector) {
        Ratio mx = e1.x().multiply(vector.x()).add(e2.x().multiply(vector.y()));
        Ratio my = e1.y().multiply(vector.x()).add(e2.y().multiply(vector.y()));
        return new Vector(mx, my);
    }
}
