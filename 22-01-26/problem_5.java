import java.util.*;

class problem_5{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Employee1 details:");
        int id1 = sc.nextInt();
        String name1 = sc.next();
        int monthlySalary1 = sc.nextInt();

        System.out.println("Enter Employee2 details:");
        int id2 = sc.nextInt();
        String name2 = sc.next();
        int monthlySalary2 = sc.nextInt();
        System.out.println();
        Employee em1 = new Employee(id1, name1, monthlySalary1);
        Employee em2 = new Employee(id2, name2, monthlySalary2);

        em1.displayEmployeeDetails(id1, name1, monthlySalary1);
        em2.displayEmployeeDetails(id2, name2, monthlySalary2);
        ////

    }
}

class Employee {
    private int id;
    private String name;
    private int monthlySalary;
    static String companyName = "Innovatechs";

    public Employee(int id, String name, int monthlySalary) {
        this.id = id;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public static int calculateAnnualSalary(int monthlySalary) {
        return 12 * monthlySalary;
    }

    public static void displayEmployeeDetails(int id, String name, int monthlySalary) {
        System.out.println("Employee Details are:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Company Name: "+companyName);
        System.out.println("Annual Salary: "+ calculateAnnualSalary(monthlySalary));
        System.out.println();
    }

}
