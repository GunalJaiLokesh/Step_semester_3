package OOP_fundamentals.Class_problems;

class SrmStudent{
    String name;
    static String collegeName;
    static String academicYear;
    static{
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-2027";
        System.out.println("College and Academic Year loaded.");
    }
    SrmStudent(String name){
        this.name = name;
        System.out.println("Student Created: " + this.name);
    }
}
public class Q4{
    public static void main(String[] args)
    {
        String[] names = {"Arun", "Bala", "Charan", "Divya"};
        SrmStudent[] students = new SrmStudent[names.length];
        for(int i = 0; i < names.length; i++){
            students[i] = new SrmStudent(names[i]);
        }
        System.out.println("\nCollege Name : " + SrmStudent.collegeName);
        System.out.println("Academic Year: " + SrmStudent.academicYear);
    }
}