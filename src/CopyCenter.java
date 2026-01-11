import java.util.ArrayList;

public class CopyCenter {
    private ArrayList<Boolean> copyMachineIsUsed;

    public CopyCenter(int copyMachine) {
        copyMachineIsUsed = new ArrayList<>();

        for(int i = 0; i < copyMachine; i++){
            //Valor por defecto -> false = no está siendo utilizada; true = está siendo utilizada
            copyMachineIsUsed.add(false);
        }
    }

    public synchronized int useCopyMachine() throws InterruptedException {
        while(!copyMachineIsUsed.contains(false)) {
            wait();
        }

        int copyMachineToBeUsedIndex = copyMachineIsUsed.indexOf(false);
        copyMachineIsUsed.set(copyMachineToBeUsedIndex, true);

        return copyMachineToBeUsedIndex;
    }

    public synchronized void releaseCopyMachine(int copyMachineIndex) {
        copyMachineIsUsed.set(copyMachineIndex, false);
        notifyAll();
    }

}
