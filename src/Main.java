import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeManager manager = new EmployeeManager();

        Employee emp1 = new Employee(1, "amit", "HR", 70000);
        Employee emp2 = new Employee(2, "bakul", "ACCOUNTS", 74000);
        Employee emp3 = new Employee(3, "vivek", "HR", 56000);
        Employee emp4 = new Employee(4, "tilak", "IT", 705000);
        Employee emp5 = new Employee(1, "avinash", "IT", 54300);

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);
        manager.addEmployee(emp4);
        manager.addEmployee(emp5);

        // Retrieve employees by department
        System.out.println("\nEmployees in HR Department:");
        manager.getEmployeeByDepartment("HR").forEach(System.out::println);

        //Retrive all employee sorted by salary
        System.out.println("\nAll Employees Sorted By Salary:");
        manager.getEmployeesSortedBySalary().forEach(System.out::println);

        System.out.println("----------------------------------------");
        //Display All employees
        manager.displayAllEmployees();

        System.out.println("Highest Paid Employee By Department:");
        Map<String, Employee> highestPaidByDept = manager.highestPaidEmployeeByDepartment();
        highestPaidByDept.forEach((dept, emp) -> System.out.println(dept + ": " + emp));

    }
}