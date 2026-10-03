package Class_problem;

abstract class Question {
    String questionText;
    int marks;
    Question(String questionText, int marks) {
        this.questionText = questionText;
        this.marks = marks;
    }
    abstract boolean evaluate(String answer);
}
class MultipleChoiceQuestion extends Question {
    String correctOption;
    MultipleChoiceQuestion(String questionText,int marks,String correctOption) {
        super(questionText, marks);
        this.correctOption = correctOption;
    }
    boolean evaluate(String answer) {
        return correctOption.equalsIgnoreCase(answer);
    }
}
class TrueFalseQuestion extends Question {
    String correctAnswer;
    TrueFalseQuestion(String questionText,int marks,String correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }
    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
class ShortAnswerQuestion extends Question {
    String correctAnswer;
    ShortAnswerQuestion(String questionText,int marks,String correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }
    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}
class Student {
    String name;
    Student(String name) {
        this.name = name;
    }
}
class Examination {
    String examName;
    Question[] questions;
    Examination(String examName,Question[] questions) {
        this.examName = examName;
        this.questions = questions;
    }
}
class Attempt {
    Student student;
    Examination exam;
    String[] answers;
    String status;
    Attempt(Student student,Examination exam) {
        this.student = student;
        this.exam = exam;
        this.answers =new String[exam.questions.length];
        status = "InProgress";
        System.out.println(exam.examName+ " started by "+ student.name + ".");
    }
    void recordAnswer(int questionNumber,String answer) {
        if (status.equals("Submitted")) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        answers[questionNumber] = answer;
        System.out.println("Answer recorded for Question "+ (questionNumber + 1) + ".");
    }
    void submitExam() {
        status = "Submitted";
        System.out.println(
                exam.examName
                + " submitted by "
                + student.name + ".");
        int totalScore = 0;
        int totalMarks = 0;
        System.out.println("Result:");
        for (int i = 0;i < exam.questions.length;i++) {
            totalMarks += exam.questions[i].marks;
            if (exam.questions[i].evaluate(answers[i])) {
                totalScore +=exam.questions[i].marks;
                System.out.println("Question "+ (i + 1)+ ": Correct ("+ exam.questions[i].marks+ " points)");
            } else {
                System.out.println("Question "+ (i + 1)+ ": Incorrect (0 points)");
            }
        }
        System.out.println(
                "Total score: "
                + totalScore
                + "/"
                + totalMarks);
    }
}
public class Q3 {
    public static void main(String[] args) {
        Student s1 =new Student("Student 1");
        Question q1 =new MultipleChoiceQuestion("MCQ Question",5,
                        "C");
        Question q2 =new TrueFalseQuestion("TF Question",5,"False");
        Question[] questions ={q1, q2};
        Examination exam =new Examination("Exam A",questions);
        Attempt attempt =new Attempt(s1, exam);
        attempt.recordAnswer(0, "C");
        attempt.recordAnswer(1, "True");
        attempt.submitExam();
        attempt.recordAnswer(0, "A");
    }
}