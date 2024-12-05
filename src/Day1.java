import java.util.*;
import java.util.stream.Collectors;


class EmployeeManager{
    private Set<Employee> employees;

    public EmployeeManager() {
        this.employees = new HashSet<>();
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

    public Set<Employee> getEmployeeByDepartment(String departmentName){
        return employees.stream()
                .filter(e->e.getDepartment().equalsIgnoreCase(departmentName))
                .collect(Collectors.toSet());
    }
    public Set<Employee> getEmployeesSortedBySalary(){
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toSet());
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