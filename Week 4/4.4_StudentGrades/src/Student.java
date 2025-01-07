public class Student {
    private static int studentIDGenerator = 0;
    private int studentID;
    private double[] grades;

    Student() {
        this.studentID = ++studentIDGenerator;
        this.grades = new double[3];
    }

    public void setGrade(double grade, int exam) {
        grades[exam] = grade;
    }

    public double getGrade(int exam) {
        return grades[exam];
    }

    public double getFinalGrade() {
        return Math.round(((0.1 * grades[0]) + (0.1 * grades[1]) + (0.8 * grades[2])) * 100.0) / 100.0;
    }

    public double getAverageGrade() {
        return Math.round(((grades[0] + grades[1] + grades[2]) / 3) * 100.0) / 100.0;
    }

    public int getStudentID() {
        return studentID;
    }
}
