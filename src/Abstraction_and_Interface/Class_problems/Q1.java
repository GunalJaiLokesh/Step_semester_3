package Abstraction_and_Interface.Class_problems;

public class Q1 {

    static abstract class Toy {
        private static int toysCreated = 0;

        private final String toyId;
        private String name;

        public Toy(String name) {
            toysCreated++;
            this.toyId = "TOY-" + (1000 + toysCreated);
            this.name = name;
        }
        public abstract String makeSound();
        String getToyId() {
            return toyId;
        }
        String getName() {
            return name;
        }
    }
    static class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }
        @Override
        public String makeSound() {
            return getName() + ": Vroom vroom!";
        }
    }
    static class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }
        @Override
        public String makeSound() {
            return getName() + ": Beep boop!";
        }
    }
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId()); 
        System.out.println(r.getToyId());
    }
}