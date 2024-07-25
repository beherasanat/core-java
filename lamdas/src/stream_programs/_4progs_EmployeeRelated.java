package stream_programs;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _4progs_EmployeeRelated {
    public static void main(String[] args) {
        List<Employee> empList = List.of(new Employee(1000.1, "Male", "IT", "name 1"),
                new Employee(3000.1, "FeMale", "QA", "name 2"),
                new Employee(5000.1, "Male", "DEV", "name 3"),
                new Employee(1500.1, "FeMale", "IT", "name 4"));

        getHighestSal(empList);
    }

    public static void getHighestSal(List<Employee> empList) {
        empList.stream().map(e -> e.salary).mapToDouble(a->a).max().ifPresent(System.out::println);
        empList.stream().sorted((a,b)->a.salary<b.salary?1:a.salary==b.salary?0:-1).limit(1).forEach(System.out::println);
        empList.stream().sorted((a,b)->b.salary<a.salary?1:a.salary==b.salary?0:-1).limit(1).forEach(System.out::println);
        System.out.println(empList.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.counting())));
        empList.stream().map(e -> e.department).distinct().forEach(i -> System.out.print(i + ", "));
        System.out.println(empList.stream().collect(Collectors.groupingBy(e->e.gender, Collectors.averagingDouble(e->e.salary))));
        Optional<Employee> emp = empList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e->e.salary)));
        emp.ifPresent(System.out::println);
    }

}

class Employee {
    String name;
    double salary;
    String gender;
    String department;

    Employee(double salary, String gender, String department, String name) {
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.name = name;
    }
    @Override
    public String toString() {
        return "[salary=" + salary + ", gender=" + gender + ", department=" + department + ", name=" + name+"],";
    }
}