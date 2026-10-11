package OOP_Inheritance_and_Polymorphism.Assignment_problems;

public class Q1 {
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
    }
    static class PremiumMember extends GymMember {
        private String trainerName;
        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }
    }
    static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        for (int i = 0; i < memberIds.length; i++) {
            try {
                new GymMember(memberIds[i], monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
    public static void main(String[] args) {
        try {
            new GymMember("GM1", 1000);
            System.out.println("construction accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended());
        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(signUpBatch(ids, 1000));    // Signed Up: 3 | Rejected: 2
    }
}