package Assignment_problem;

interface NotificationChannel {
    void send(String studentName, String noticeTitle);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("[Email -> " + studentName + "] "
                + noticeTitle);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("[SMS -> " + studentName + "] "
                + noticeTitle);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String noticeTitle) {
        System.out.println("[App -> " + studentName + "] "
                + noticeTitle);
    }
}

class Student {
    String name;
    String department;
    NotificationChannel[] channels;

    Student(String name, String department,
            NotificationChannel[] channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }
}

class Notice {
    String title;
    String[] targetDepartments;

    Notice(String title, String[] targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }

    boolean isValid() {
        return title != null
                && !title.equals("")
                && targetDepartments.length > 0;
    }
}

class NoticeBoard {
    Student[] students;

    NoticeBoard(Student[] students) {
        this.students = students;
    }

    void postNotice(Notice notice) {

        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.print("Notice '" + notice.title
                + "' posted to ");

        for (int i = 0; i < notice.targetDepartments.length; i++) {
            System.out.print(notice.targetDepartments[i]);

            if (i < notice.targetDepartments.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".");

        for (int i = 0; i < students.length; i++) {

            boolean targetStudent = false;

            for (int j = 0; j < notice.targetDepartments.length; j++) {
                if (students[i].department
                        .equals(notice.targetDepartments[j])) {
                    targetStudent = true;
                    break;
                }
            }

            if (targetStudent) {
                for (int k = 0;
                     k < students[i].channels.length;
                     k++) {

                    students[i].channels[k]
                            .send(students[i].name,
                                    notice.title);
                }
            }
        }
    }
}

public class Q5 {
    public static void main(String[] args) {

        Student asha = new Student(
                "Asha",
                "CSE",
                new NotificationChannel[]{
                        new EmailChannel(),
                        new AppChannel()
                });
        Student ravi = new Student(
                "Ravi",
                "ECE",
                new NotificationChannel[]{new SmsChannel()
                });
        Student[] students = {asha, ravi};
        NoticeBoard board =new NoticeBoard(students);
        Notice n1 = new Notice("Lab Closed Tomorrow",new String[]{"CSE"});
        board.postNotice(n1);
        System.out.println();
        Notice n2 = new Notice("Fee Deadline Extended",new String[]{"CSE", "ECE"});
        board.postNotice(n2);
        System.out.println();
        Notice n3 = new Notice("Sports Day",new String[]{});
        board.postNotice(n3);
    }
}