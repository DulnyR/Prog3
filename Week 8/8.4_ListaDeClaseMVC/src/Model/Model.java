package Model;

public class Model {
    StudentInfo[] students;

    public Model() {
        students = new StudentInfo[20];
        for(int i = 0; i < students.length; i++) {
            students[i] = new StudentInfo();
        }
    }

    public StudentInfo[] getStudents() {
        return students;
    }
}
