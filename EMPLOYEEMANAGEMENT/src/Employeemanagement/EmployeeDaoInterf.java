package Employeemanagement;

public interface EmployeeDaoInterf {
    // create employee
    public void createEmployee(Employee emp);

    // show all employee
    public void showAllEmployee();

    //show employee based on id
    public void showEmployeeBasedOnID(int id );

    //update employee name
    public void updateEmployee(int id, String name);

    //update employee salary
    public void updateEmployeeSalary(int id, int salary);

    //update employee age
    public void updateEmployeeAge(int id, int age);

    //delete employee
    public void deleteEmployee(int id);
}
