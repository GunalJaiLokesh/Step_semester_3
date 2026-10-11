package Abstraction_and_Interface.Assignment_problems;

public class Q5 {
    static abstract class Drone {
        public Drone() {
        }
        public abstract String fly();
    }
    public interface Trackable {
        String getLocation();
    }
    static class DeliveryDrone extends Drone implements Trackable {
        private String id;
        public DeliveryDrone(String id) {
            super();
            this.id = id;
        }
        @Override
        public String fly() {
            return id + " flying a delivery route";
        }
        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }
    static class ScoutDrone extends Drone {
        private String id;
        public ScoutDrone(String id) {
            super();
            this.id = id;
        }
        @Override
        public String fly() {
            return id + " scouting the area";
        }
    }
    static class GroundRobot implements Trackable {
        private String id;
        public GroundRobot(String id) {
            this.id = id;
        }
        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }
    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        } else {
            return "Tracking not available";
        }
    }
    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(d));  
        System.out.println(getLocationIfTrackable(s));  
        System.out.println(getLocationIfTrackable(g));  
    }
}