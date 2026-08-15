package LLD.DesignPattern.CompositePattern;


/*
Problem: Company Hierarchy
A company consists of employees and departments.
Each department can contain
Employees
Other Departments
Operations
showDetails()
calculateSalary()
Example
Company
   Engineering
       Backend
           Alice
           Bob
       Frontend
           Charlie
   HR
       David
 */

import java.util.ArrayList;
import java.util.List;

public class CompanyHierarchyComposite {
    public static void main(String[] args) {
        // Instead of messing client side use Builder Pattern
//        Department company = new Department("Company ");
//        Department engineering = new Department("Engineering ");
//        Department backend = new Department("Backend ");
//        Department frontend = new Department("Frontend ");
//        Department hr = new Department("HR ");
//
//        backend.add(new Employee("Alice",50000));
//        backend.add(new Employee("Bob",40000));
//        frontend.add(new Employee("Charlie",60000));
//
//        hr.add(new Employee("David",45000));
//        engineering.add(backend);
//        engineering.add(frontend);
//        company.add(engineering);
//        company.add(hr);
//
//        company.showDetails();
//        System.out.println(company.calculateSalary());


        Department backend = new DepartmentBuilder("Backend ")
                .addEmployee("Alice",50000)
                .addEmployee("Bob",40000)
                .build();
        Department frontend = new DepartmentBuilder("Frontend ")
                .addEmployee("Charlie",60000)
                .build();

        Department engineering = new DepartmentBuilder("Engineering ")
                .addDepartment(backend)
                .addDepartment(frontend)
                .build();

        Department hr = new DepartmentBuilder("HR ")
                .addEmployee("David",45000)
                .build();

        Department company = new DepartmentBuilder("Company")
                .addDepartment(engineering)
                .addDepartment(hr)
                .build();

        company.showDetails();
        System.out.println("Total salary -> " + company.calculateSalary());
    }
}


interface CompanyDetails {
    void showDetails();
    Integer calculateSalary();
}


class Employee implements CompanyDetails {
    private final String name;
    private final Integer salary;

    Employee(String name,Integer salary){
        this.name = name;
        this.salary = salary;

    }

    @Override
    public void showDetails() {
        System.out.println(name);
    }

    @Override
    public Integer calculateSalary() {
        System.out.println(name +" -> "+salary);
       return salary;
    }
}


class Department implements CompanyDetails {
    List<CompanyDetails> details = new ArrayList<>();
    private final String name;

    Department(String name){
        this.name = name;
    }

    public void add(CompanyDetails newDetail){
        details.add(newDetail);
    }

    @Override
    public void showDetails() {
        showDetails(0);
    }

    private void showDetails(int level){
        System.out.println(indent(level) + name);
        for(CompanyDetails children: details){
            if(children instanceof Department)
                ((Department) children).showDetails(level+1);
            else {
                System.out.print(indent(level + 1));
                children.showDetails();
            }
        }
    }

    private String indent(int level) {
        return "    ".repeat(level);
    }

    @Override
    public Integer calculateSalary() {
        //BETTER WAY
        int sum = 0; // department salary
        for(CompanyDetails children: details){
            sum += children.calculateSalary();
        }
        return sum;

//        return calculateSalary(0);
    }

//    private int calculateSalary(int level){
//        int sum = 0;
//
//        for(CompanyDetails children: details){
//            if(children instanceof Department)
//                sum += ((Department) children).calculateSalary(level+1);
//            else {
//                System.out.print(indent(level + 1));
//                sum += children.calculateSalary();
//            }
//        }
//        System.out.println(indent(level) + name+" -> "+ sum);
//
//        return sum;
//    }
}


class DepartmentBuilder{
    private final Department department;

    DepartmentBuilder(String departmentName){
        this.department = new Department(departmentName);
    }

    DepartmentBuilder addEmployee(String name, int salary){
        department.add(new Employee(name,salary));
        return this;
    }

    public DepartmentBuilder addDepartment(Department department) {
        this.department.add(department);
        return this;
    }

    public Department build() {
        return department;
    }
}