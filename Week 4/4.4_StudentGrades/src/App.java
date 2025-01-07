import com.coti.tools.Esdia;

public class App {
    public static void main(String[] args) throws Exception {
        int numberOfStudents = Esdia.readInt("Number of students: ");

        Student[] students = new Student[numberOfStudents];
        for(int i = 0; i < numberOfStudents; i++) {
            students[i] = new Student();
        }

        for(Student student : students) {
            for(int exam = 0; exam < 3; exam++) {
                student.setGrade(Esdia.readDouble("What grade did student " + student.getStudentID() + " get in exam number " + (exam + 1) + "?"), exam);
            }
        }

        System.out.println("ID\tExam 1\tExam 2\tExam 3\tFinal\tAverage");
        for(Student student : students) {
            System.out.print(student.getStudentID() + "\t");
            for(int exam = 0; exam < 3; exam++) {
                System.out.print(student.getGrade(exam) + "\t");
            }
            System.out.print(student.getFinalGrade() + "\t");
            System.out.print(student.getAverageGrade());
            System.out.println();
        }
    }
}
