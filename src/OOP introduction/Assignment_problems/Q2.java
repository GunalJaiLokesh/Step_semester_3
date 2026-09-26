package Assignment_problems;

import java.util.Scanner;

class payrollAccount{
    private double basicsalary;
    private double bonus;

    public payrollAccount(double basicsalary, double bonus){
        this.basicsalary = basicsalary;
        this.bonus = bonus;
        if(basicsalary <=0){
            this.basicsalary =0;
            System.out.println("basic salary cannot be zero or negative ");
        }
    }
    public void creditBonus(double amount){
        if(amount<0){
            System.out.println("Bonus cannot be zero ");
        }else{
            bonus = amount;
            System.out.println("Bonus is "+bonus);
        }
    }
    public void deductTax(double percentage){
        if(percentage>100||percentage<0){
            System.out.println("Percentage must be within 0 - 100");
        }
        else{
            basicsalary -= (basicsalary*percentage)/100;
            System.out.println("Salary after deducting tax is "+basicsalary);
        }
    }
    public void getNetSalary(){
        System.out.println("Net salary is"+basicsalary+bonus);
    }
}
public class Q2 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter basic salary");
        double basic = sc.nextDouble();
        System.out.println("Enter bonus amount");
        double amount = sc.nextDouble();
        System.out.println("Enter tax percentage");
        double percentage = sc.nextDouble();
        payrollAccount p = new payrollAccount(basic, amount);
        p.creditBonus(amount);
        p.deductTax(percentage);
        p.getNetSalary();
        sc.close();
    }   
}
