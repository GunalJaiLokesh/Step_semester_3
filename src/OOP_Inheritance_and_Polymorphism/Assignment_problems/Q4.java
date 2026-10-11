package OOP_Inheritance_and_Polymorphism.Assignment_problems;

public class Q4 {
    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private int sessionsAttended;
        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId");
            }
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }
        void attendSession() {
            sessionsAttended++;
        }
        int getSessionsAttended() {
            return sessionsAttended;
        }
        String displayInfo() {
            return "Standard | Sessions: " + getSessionsAttended();
        }
    }
    static class PremiumMember extends GymMember {
        private String trainerName;
        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }
        String getTrainerName() {
            return trainerName;
        }
        @Override
        String displayInfo() {
            return "Premium | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
        }
    }
    static String batchPrint(GymMember[] members) {
        StringBuilder announcement = new StringBuilder(); 
        for (int i = 0; i < members.length; i++) {
            announcement.append(members[i].displayInfo());
            if (members[i] instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) members[i];
                announcement.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            }
            announcement.append(" | ");
        }
        return announcement.toString();
    }
    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(batchPrint(members));
        GymMember plain = new GymMember("MEM8", 1000);
        try {
            PremiumMember bad = (PremiumMember) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}