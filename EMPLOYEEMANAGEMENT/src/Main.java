//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Employeemanagement.Employee;
import Employeemanagement.EmployeeDaoImpl;
import Employeemanagement.EmployeeDaoInterf;
//import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String name; // To store employee name input
        int id ; // To store employee ID input
        EmployeeDaoInterf dao = new EmployeeDaoImpl();
        System.out.println("WELCOME TO THE EMPLOYEE MANAGEMENT APPLICATION");
        Scanner sc= new Scanner(System.in);

        // Flag to control the main application loop.
        boolean running = true;
        do{
            // Display the main menu options to the user.
            System.out.println("1.add employee");
            System.out.println("2.show all employee");
            System.out.println("3.show employee based on id ");
            System.out.println("4.update the employee");
            System.out.println("5.delete the employee");
            System.out.println("6. Update Employee Salary");
            System.out.println("7. Update Employee Age");

            System.out.println("ENTER YOUR CHOICE : ");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("ENTER ID : ");
                    id= sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER NAME : ");
                    name = sc.nextLine();
                    System.out.println("ENTER SALARY : ");
                    double salary = sc.nextDouble();
                    System.out.println("ENTER AGE : ");
                    int age= sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary((int) salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter the ID to get Employee details ");
                    int empid= sc.nextInt();
                    sc.nextLine();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter the id to update the details of the Employee : ");
                    empid=sc.nextInt();
                    System.out.println("Enter the name that you want to update : ");
                    name=sc.nextLine();
                    dao.updateEmployee(empid,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete the employee ");
                    id= sc.nextInt();
                    dao.deleteEmployee(id);
                    break;
                case 6: // Case to update an employee's salary
                    System.out.println("Enter the ID of the Employee to update salary: ");
                    empid = sc.nextInt();
                    System.out.println("Enter the NEW salary: ");
                    salary = sc.nextDouble();
                    // Call a DAO method to update the employee's salary.
                    // You'll need to implement a updateEmployeeSalary method in your EmployeeDaoInterf and EmployeeDaoImpl.
                    dao.updateEmployeeSalary(empid, (int) salary); // Assuming salary is stored as int
                    break;

                case 7: // Case to update an employee's age
                    System.out.println("Enter the ID of the Employee to update age: ");
                    empid = sc.nextInt();
                    System.out.println("Enter the NEW age: ");
                    age = sc.nextInt();
                    // Call a DAO method to update the employee's age.
                    // You'll need to implement a updateEmployeeAge method in your EmployeeDaoInterf and EmployeeDaoImpl.
                    dao.updateEmployeeAge(empid, age);
                    break;

                case 8: // Case to exit the application
                    System.out.println("Exiting Employee Management Application. Goodbye!");
                    running = false; // Set the flag to false to terminate the do-while loop
                    break;
                default:
                    System.out.println(" you have entered invalid choice " + choice );
            }
        }while(running);

    }
}