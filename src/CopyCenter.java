import java.util.ArrayList;

public class CopyCenter {
    private ArrayList<Boolean> copyMachineIsUsed;

    public CopyCenter(int copyMachine) {
        copyMachineIsUsed = new ArrayList<>();

        for(int i = 0; i < copyMachine; i++){
            copyMachineIsUsed.add(false);
        }
    }

    public synchronized int useCopyMachine() {
        while(!copyMachineIsUsed.contains(false)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int machineToBeUsed = copyMachineIsUsed.indexOf(false);
        copyMachineIsUsed.set(machineToBeUsed, true);

        return machineToBeUsed;
    }

    public synchronized void releaseCopyMachine(int copyMachineIndex) {

        try {
            Thread.sleep(700);
            copyMachineIsUsed.set(copyMachineIndex, false);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
