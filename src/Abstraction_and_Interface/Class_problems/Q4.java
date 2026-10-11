package Abstraction_and_Interface.Class_problems;

public class Q4 {
    static abstract class KitchenTool {
        private int speedLevel = 1;
        public KitchenTool() {
        }
        public abstract String prepare();
        int getSpeedLevel() {
            return speedLevel;
        }
        void setSpeedLevel(int speedLevel) {
            if (speedLevel < 1 || speedLevel > 5) {
                System.out.println("rejected, speed level stays " + this.speedLevel);
                return;
            }
            this.speedLevel = speedLevel;
        }
    }
    public interface Washable {
        String clean();
    }
    static class Blender extends KitchenTool implements Washable {
        public Blender() {
            super();
        }
        @Override
        public String prepare() {
            return "Blending at speed " + getSpeedLevel();
        }
        @Override
        public String clean() {
            return "Blender rinsed and dried";
        }
    }
    public static void main(String[] args) {
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel());
        b.setSpeedLevel(9);    
        System.out.println(b.getSpeedLevel());
        System.out.println(b.prepare());
        System.out.println(b.clean());
    }
}