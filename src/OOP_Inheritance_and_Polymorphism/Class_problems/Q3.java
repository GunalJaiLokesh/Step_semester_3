package OOP_Inheritance_and_Polymorphism.Class_problems;

public class Q3 {
    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;
        private int[] fineHistory = new int[10];
        private int fineCount = 0;
        private int totalFine = 0;
        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId");
            }
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }
        protected void chargeFine(int amount) {
            if (fineCount < fineHistory.length) {
                fineHistory[fineCount] = amount;
                fineCount++;
                totalFine += amount;
            }
        }
        int[] getFineHistory() {
            int[] copy = new int[fineCount];
            for (int i = 0; i < fineCount; i++) {
                copy[i] = fineHistory[i];
            }
            return copy;
        }
        int getTotalFine() {
            return totalFine;
        }
    }
    static class StudentMember extends LibraryMember {
        private String course;
        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }
        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
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
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());
        int[] history = s.getFineHistory();
        history[0] = 999;
        printArray(s.getFineHistory()); 
    }
}