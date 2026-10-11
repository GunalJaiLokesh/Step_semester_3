package OOP_Inheritance_and_Polymorphism.Assignment_problems;

public class Q3 {
    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private int sessionsAttended;
        private int[] lateFeeHistory = new int[10];
        private int feeCount = 0;
        private int totalLateFees = 0;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId");
            }
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }
        protected void chargeLateFee(int amount) {
            if (feeCount < lateFeeHistory.length) {
                lateFeeHistory[feeCount] = amount;
                feeCount++;
                totalLateFees += amount;
            }
        }
        int[] getLateFeeHistory() {
            int[] copy = new int[feeCount];
            for (int i = 0; i < feeCount; i++) {
                copy[i] = lateFeeHistory[i];
            }
            return copy;
        }
        int getTotalLateFees() {
            return totalLateFees;
        }
    }
    static class PremiumMember extends GymMember {
        private String trainerName;
        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }
        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);  
        }
    }
    static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");
        p.chargeLateFee(200);
        System.out.println(p.getTotalLateFees());  

        int[] history = p.getLateFeeHistory();
        history[0] = 999; 
        printArray(p.getLateFeeHistory()); 
    }
}
