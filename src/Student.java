public class Student implements Runnable {
    private int number;
    private CopyCenter copyCenter;
    private int timesHasUsedMachine = 0;

    public Student(int number, CopyCenter copyCenter) {
        this.number = number;
        this.copyCenter = copyCenter;
    }

    public int getTimesHasUsedMachine() {
        return timesHasUsedMachine;
    }

    public int getNumber() {
        return number;
    }

    private void study() throws InterruptedException {
        System.out.println("El estudiante " + (number + 1) + " está estudiando");

        Thread.sleep((int) (Math.random() * 5000));
    }

    private void useCopyMachine() throws InterruptedException {
        int copyMachineUsedIndex = copyCenter.useCopyMachine();
        System.out.println("El estudiante " + (number + 1) + " usa la máquina " + (copyMachineUsedIndex + 1));

        timesHasUsedMachine++;

        Thread.sleep(700);
        copyCenter.releaseCopyMachine(copyMachineUsedIndex);

        System.out.println("El estudiante " + (number + 1) + " libera la máquina " + (copyMachineUsedIndex + 1));
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                study();

                System.out.println("El estudiante " + (number + 1) + " va al centro de fotocopias y solicita una máquina.");

                useCopyMachine();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("El estudiante " + (number + 1) + " ha terminado su jornada de estudio.");
    }
}
