package Employeemanagement;
//bean class
public class Employee {

    private int id;
    private int salary;
    private String name ;
    private int age;

    //default constructor
    public Employee(){

    }

    // constructor
    public Employee(int id, int salary, String name, int age) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.age = age;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //to string
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
