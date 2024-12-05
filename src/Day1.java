import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day1 {
}
class EmployeeManager{
    private List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public boolean isDuplicateEmployee(int id){
        return employees.stream().anyMatch(e->e.getId()==id);
    }

    public void addEmployee(Employee e){
        if(!isDuplicateEmployee(e.getId())){
            employees.add(e);
        }
        else {
            System.out.println("Duplicate ID "+e.getId());
        }
    }

    public List<Employee> getEmployeeByDepartment(String departmentName){
        return employees.stream()
                .filter(e->e.getDepartment().equalsIgnoreCase(departmentName))
                .collect(Collectors.toList());
    }
    public List<Employee> getEmployeesSortedBySalary(){
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }


    public void displayAllEmployees(){
        employees.forEach(System.out::println);
    }

    public Map<String, Employee> highestPaidEmployeeByDepartment() {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Classifier function
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get
                        )
                ));
    }

}