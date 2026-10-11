package OOP_Inheritance_and_Polymorphism.Assignment_problems;

public class Q2 {
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
            return "Standard Member | Sessions: " + getSessionsAttended();
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
            return "Premium Member | Trainer: " + trainerName
                    + " | Sessions: " + getSessionsAttended();
        }
    }
    static class EliteMember extends PremiumMember {
        private String lockerNumber;
        public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
            super(memberId, monthlyFee, trainerName);
            this.lockerNumber = lockerNumber;
        }
        @Override
        String displayInfo() {
            return "Elite Member | Trainer: " + getTrainerName()
                    + " | Locker: " + lockerNumber
                    + " | Sessions: " + getSessionsAttended();
        }
    }
    static class GroupClassMember extends GymMember {
        private String className;
        public GroupClassMember(String memberId, int monthlyFee, String className) {
            super(memberId, monthlyFee);
            this.className = className;
        }
        @Override
        String displayInfo() {
            return "Group Class Member | Class: " + className
                    + " | Sessions: " + getSessionsAttended();
        }
    }
    static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof PremiumMember) {
            return "Single inheritance child (2 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else {
            return "Base class (root of the tree)";
        }
    }
    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        for (int i = 0; i < members.length; i++) {
            total += members[i].getSessionsAttended();
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(new GymMember("MEM1", 1000).displayInfo());
        System.out.println(new PremiumMember("MEM2", 2000, "Coach Riya").displayInfo());
        System.out.println(new EliteMember("MEM3", 3000, "Coach Arjun", "L12").displayInfo());
        System.out.println(new GroupClassMember("MEM4", 1500, "Zumba").displayInfo());
        PremiumMember premiumMember = new PremiumMember("MEM5", 2000, "Coach Riya");
        EliteMember eliteMember = new EliteMember("MEM6", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember = new GroupClassMember("MEM7", 1500, "Zumba");
        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));
        for (int i = 0; i < 3; i++) premiumMember.attendSession();
        for (int i = 0; i < 2; i++) eliteMember.attendSession();
        for (int i = 0; i < 4; i++) groupClassMember.attendSession();
        GymMember[] all = {premiumMember, eliteMember, groupClassMember};
        System.out.println(getTotalSessionsAttended(all));
    }
}