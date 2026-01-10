public class Student implements Runnable {
    private int number;
    private CopyCenter copyCenter;

    public Student(int number, CopyCenter copyCenter) {
        this.number = number;
        this.copyCenter = copyCenter;
    }

    public void studying() {
        System.out.println("El estudiante " + (number + 1) + " está estudiando");

        try {
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            studying();
            System.out.println("El estudiante " + (number + 1) + " va al centro de fotocopias.");
            int machineUsed = copyCenter.useCopyMachine();
            System.out.println("El estudiante " + (number + 1) + " usa la máquina " + (machineUsed + 1));
            copyCenter.releaseCopyMachine(machineUsed);
            System.out.println("El estudiante " + (number + 1) + " libera la máquina " + (machineUsed +1));
        }
    }
}
