package Assignment_problem;

abstract class Assignment {
    protected String title;
    protected int maxMarks;

    public Assignment(String title, int maxMarks) {
        this.title = title;
        this.maxMarks = maxMarks;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public abstract double applyPenalty(double marks, int lateDays);
}

class CodingAssignment extends Assignment {

    public CodingAssignment(String title, int maxMarks) {
        super(title, maxMarks);
    }

    public double applyPenalty(double marks, int lateDays) {
        return marks * (1 - 0.10 * lateDays);
    }
}

class WrittenAssignment extends Assignment {

    public WrittenAssignment(String title, int maxMarks) {
        super(title, maxMarks);
    }

    public double applyPenalty(double marks, int lateDays) {
        return marks * (1 - 0.20 * lateDays);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private int lateDays;
    private String status;

    public Submission(Student student,
                      Assignment assignment,
                      int lateDays) {

        this.student = student;
        this.assignment = assignment;
        this.lateDays = lateDays;
        status = "Submitted";

        if (lateDays == 0) {
            System.out.println(student.getName()
                    + "'s submission for '"
                    + assignment.getTitle()
                    + "' received (on time). Status: "
                    + status);
        } else {
            System.out.println(student.getName()+ "'s submission for '"+ assignment.getTitle()+ "' received ("+ lateDays
                    + " days late). Status: "
                    + status);
        }
    }
    public void grade(double awardedMarks) {
        if (status.equals("Graded")) {
            System.out.println("Already graded");
            return;
        }
        double finalMarks =assignment.applyPenalty(awardedMarks,lateDays);
        status = "Graded";
        System.out.println(student.getName()+ " graded: "+ (int) finalMarks + "/"+ assignment.getMaxMarks() + ". Status: "+ status);
    }
    public void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '"+ assignment.getTitle()+ "' has already been graded.");
            return;
        }
        System.out.println("Resubmission successful");
    }
}
public class Q2 {
    public static void main(String[] args) {
        Assignment coding =new CodingAssignment("Linked List Lab",50);
        Assignment written =new WrittenAssignment("Design Essay",50);
        Student asha =new Student("Asha");
        Student ravi =new Student("Ravi");
        Submission s1 =new Submission(asha,coding,0);
        Submission s2 =new Submission(ravi,written,2);
        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}