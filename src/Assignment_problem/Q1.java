package Assignment_problem;
interface WashType {
    int getDuration();
    double getCharge();
    String getTypeName();
}

class QuickWash implements WashType {
    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20.0;
    }

    public String getTypeName() {
        return "Quick";
    }
}

class NormalWash implements WashType {
    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30.0;
    }

    public String getTypeName() {
        return "Normal";
    }
}

class HeavyWash implements WashType {
    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45.0;
    }

    public String getTypeName() {
        return "Heavy";
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;
    public WashCycle(Student student,WashingMachine machine,WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }
    public Student getStudent() {
        return student;
    }
    public WashingMachine getMachine() {
        return machine;
    }
    public WashType getWashType() {
        return washType;
    }
}
class WashingMachine {
    private String machineId;
    private boolean busy;
    private WashCycle currentCycle;
    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
    }
    public void startWash(Student student, WashType washType) {
        if (busy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return;
        }
        currentCycle = new WashCycle(student, this, washType);
        busy = true;
        System.out.println(
            washType.getTypeName() + " wash started on "
            + machineId + " for "
            + student.getName() + " ("
            + washType.getDuration() + " min). Charge: ₹"
            + String.format("%.2f", washType.getCharge())
        );
    }
    public void completeCycle() {
        if (!busy) {
            System.out.println(machineId + " is already free.");
            return;
        }
        System.out.println(machineId + " cycle completed.");
        busy = false;
        currentCycle = null;
        System.out.println(machineId + " is now free.");
    }
    public boolean isBusy() {
        return busy;
    }
    public String getMachineId() {
        return machineId;
    }
}
public class Q1 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.startWash(asha, new QuickWash());

        m1.startWash(ravi, new HeavyWash());

        m2.startWash(ravi, new HeavyWash());

        m1.completeCycle();

        m1.startWash(neha, new NormalWash());
    }
}