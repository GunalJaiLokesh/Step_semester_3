package OOP_Inheritance_and_Polymorphism.Class_problems;

public class Q1 {
    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;
        public LibraryMember(String memberId, int borrowLimit) {
            if (memberId == null || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId");
            }
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }
        void borrowBook() {
            if (booksBorrowed < borrowLimit) {
                booksBorrowed++;
            }
        }
        int getBooksBorrowed() {
            return booksBorrowed;
        }
    }
    static class StudentMember extends LibraryMember {
        private String course;
        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
        }
    }
    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        for (int i = 0; i < memberIds.length; i++) {
            try {
                new LibraryMember(memberIds[i], borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }
    public static void main(String[] args) {
        // Example 1
        try {
            new LibraryMember("LB1", 3);
            System.out.println("construction accepted");
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed()); 
        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(enrollBatch(ids, 3));    // Enrolled: 3 | Rejected: 2
    }
}