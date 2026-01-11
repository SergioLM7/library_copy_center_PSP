import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long pogramLife = 20000;
        CopyCenter copyCenter = new CopyCenter(2);
        int numberOfStudents = 5;

        List<Thread> studentsThreads = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        for(int i = 0; i < numberOfStudents; i++) {
            Student student = new Student(i, copyCenter);
            students.add(student);

            Thread thread = new Thread(student);
            studentsThreads.add(thread);

            thread.start();
        }

        try {
            Thread.sleep(pogramLife);

            //Interrumpo todos los hilos después de 20 segundos
            for(Thread studentThread : studentsThreads) {
                studentThread.interrupt();
            }

            //Espero a que todos los hilos confirmen su finalización antes de imprimir el recuento de copias
            for(Thread studentThread : studentsThreads) {
                studentThread.join();
            }

            for(Student student : students) {
                System.out.println("El estudiante " + (student.getNumber() + 1) + " ha hecho copias " + student.getTimesHasUsedMachine() + " veces.");
            }
        } catch (InterruptedException e) {
            System.out.println("Se ha producido un error: " + e);
        }

    }
}
