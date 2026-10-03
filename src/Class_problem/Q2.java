package Class_problem;

abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
    abstract String getType();
}
class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }
    String getType() {
        return "FullTimeEmployee";
    }
}
class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }
    String getType() {
        return "PartTimeEmployee";
    }
}
class Contractor extends Employee {
    Contractor(String name) {
        super(name);
    }
    String getType() {
        return "Contractor";
    }
}
class LeaveRequest {
    Employee employee;
    String startDate;
    String endDate;
    String status;
    LeaveRequest(Employee employee,String startDate,String endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
        System.out.println( "Leave request submitted for "+ employee.name
                + " (" + startDate+ "-" + endDate + ").");
        System.out.println("Status: " + status + ".");
    }
    void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println(employee.name+ "'s leave request ("+ startDate + "-"+ endDate + ") approved.");
            System.out.println(
                    "Status: " + status + ".");
        }
    }
    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(employee.name+ "'s leave request ("
                    + startDate + "-"+ endDate + ") rejected.");
            System.out.println(
                    "Status: " + status + ".");
        }
    }
    void changeToPending() {
        if (status.equals("Approved")
                || status.equals("Rejected")) {
            System.out.println("Cannot change leave request status from "+ status + " to Pending.");
        } else {
            status = "Pending";
        }
    }
}
class Manager {
    String name;
    Manager(String name) {
        this.name = name;
    }
    void approveRequest(LeaveRequest request) {
        request.approve();
    }
    void rejectRequest(LeaveRequest request) {
        request.reject();
    }
}
public class Q2 {
    public static void main(String[] args) {
        Employee john =new FullTimeEmployee("John");
        LeaveRequest lr1 =new LeaveRequest(john,"Jan 1","Jan 5");
        Manager alice =new Manager("Alice");
        alice.approveRequest(lr1);
        Employee jane =new PartTimeEmployee("Jane");
        LeaveRequest lr2 =new LeaveRequest(jane,"Feb 10","Feb 11");
        Manager bob =new Manager("Bob");
        bob.rejectRequest(lr2);
        lr1.changeToPending();
    }
}