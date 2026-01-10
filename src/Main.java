public class Main {
    public static void main(String[] args) {
        CopyCenter copyCenter = new CopyCenter(2);
        int numberOfStudents = 5;

        for(int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(i, copyCenter);

            Thread thread = new Thread(student);
            thread.start();
        }

    }
}
