package edu.ccrm.domain;

public enum Grade {
    S(10.0, "S"),
    A(9.0, "A"), 
    B(8.0, "B"),
    C(7.0, "C"),
    D(6.0, "D"),
    E(5.0, "E"),
    F(0.0, "F");
    
    private final double gradePoints;
    private final String letterGrade;
    

    Grade(double gradePoints, String letterGrade) {
        this.gradePoints = gradePoints;
        this.letterGrade = letterGrade;
    }
    

    public double getGradePoints() {
        return gradePoints;
    }
    public String getLetterGrade() {
        return letterGrade;
    }
    public static Grade getGradeByPoints(double points) {
        if (points >= 9.5) return S;
        if (points >= 8.5) return A;
        if (points >= 7.5) return B;
        if (points >= 6.5) return C;
        if (points >= 5.5) return D;
        if (points >= 4.5) return E;
        return F;
    }
    


    
    @Override
    public String toString() {
        return letterGrade + " (" + gradePoints + ")";
    }
}