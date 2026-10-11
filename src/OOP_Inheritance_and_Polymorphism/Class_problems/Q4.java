package OOP_Inheritance_and_Polymorphism.Class_problems;

public class Q4 {
    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;
        public LibraryMember(String memberId, int borrowLimit) {
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
        String displayInfo() {
            return "General | Books: " + getBooksBorrowed();
        }
    }
    static class StudentMember extends LibraryMember {
        private String course;
        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }
        String getCourse() {
            return course;
        }
        @Override
        String displayInfo() {
            return "Student | Course: " + course + " | Books: " + getBooksBorrowed();
        }
    }
    static String batchPrint(LibraryMember[] members) {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            report.append(members[i].displayInfo());
            if (members[i] instanceof StudentMember) {
                StudentMember sm = (StudentMember) members[i];
                report.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }

            report.append(" | ");
        }
        return report.toString();
    }
    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(batchPrint(members));
        LibraryMember plain = new LibraryMember("LB6", 3);
        try {
            StudentMember bad = (StudentMember) plain;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException at runtime");
        }
    }
}
