package OOP_Inheritance_and_Polymorphism.Class_problems;

public class Q2 {
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
        String displayInfo() {
            return "General Member | Books Borrowed: " + getBooksBorrowed();
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
            return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
        }
    }
    static class HonorsStudentMember extends StudentMember {
        private int bonusLimit;
        public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }
        @Override
        String displayInfo() {
            return "Honors Student Member | Course: " + getCourse()
                    + " | Bonus Limit: " + bonusLimit
                    + " | Books Borrowed: " + getBooksBorrowed();
        }
    }
    static class FacultyMember extends LibraryMember {
        private String department;
        public FacultyMember(String memberId, int borrowLimit, String department) {
            super(memberId, borrowLimit);
            this.department = department;
        }
        @Override
        String displayInfo() {
            return "Faculty Member | Department: " + department
                    + " | Books Borrowed: " + getBooksBorrowed();
        }
    }
    static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof StudentMember) {
            return "Single inheritance child (2 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else {
            return "Base class (root of the tree)";
        }
    }
    static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (int i = 0; i < members.length; i++) {
            total += members[i].getBooksBorrowed();
        }
        return total;
    }
    public static void main(String[] args) {
        System.out.println(new LibraryMember("STU1", 3).displayInfo());
        System.out.println(new StudentMember("STU2", 3, "CSE").displayInfo());
        System.out.println(new HonorsStudentMember("STU3", 3, "ECE", 2).displayInfo());
        System.out.println(new FacultyMember("STU4", 5, "Physics").displayInfo());
        StudentMember studentMember = new StudentMember("STU5", 3, "CSE");
        HonorsStudentMember honorsMember = new HonorsStudentMember("STU6", 3, "ECE", 2);
        FacultyMember facultyMember = new FacultyMember("FAC1", 5, "Physics");
        System.out.println(classifyGeneration(honorsMember));
        System.out.println(classifyGeneration(facultyMember));
        studentMember.borrowBook();
        studentMember.borrowBook();
        honorsMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();
        LibraryMember[] all = {studentMember, honorsMember, facultyMember};
        System.out.println(getTotalBooksBorrowed(all));
    }
}