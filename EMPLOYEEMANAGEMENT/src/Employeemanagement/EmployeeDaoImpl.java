package Employeemanagement;

import java.sql.*;

public class EmployeeDaoImpl implements EmployeeDaoInterf {
    Connection con;
    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query=" insert into employee values(?,?,?,?)";
        try {
            // Set values for the placeholders in the SQL query.
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setInt(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());

            // Returns the number of rows affected.
            int cnt= pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("EMPLOYEE ENTERED SUCCESSFULLY");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //Retrieves and displays all employee records from the 'employee' table.
    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        String query="select * from employee"; // SQL query to select all data
        System.out.println("Employee details : ");

        // Print header for formatted output
        System.out.format("%s\t%s\t%s\t%s\n" ,"ID","Name","Salary","Age");
        System.out.println("----------------------------------------------------");

        try {
            Statement stmt= con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){

                // Retrieve data by column index and print in a formatted way.
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("-------------------------------------------------");


            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //Retrieves and displays details of a specific employee based on their ID.
    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query="select * from employee where id ="+id;
        try {
            Statement stmt= con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    //Updates the name of an existing employee in the database.
    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnection();
        String query="update employee set name=? where id=?";

        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);// Set the new name
            pstm.setInt(2,id); // Set the ID for the WHERE clause
            int cnt= pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("EMPLOYEE DETAILS UPDATED SUCCESSFULLY ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
    //Updates the salary of an existing employee in the database.
    @Override
    public void updateEmployeeSalary(int id, int salary) {
        con = DBConnection.createDBConnection();
        // Using PreparedStatement for safe updating.
        String query = "UPDATE employee SET salary = ? WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, salary); // Set the new salary
            pstm.setInt(2, id);      // Set the ID for the WHERE clause

            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("EMPLOYEE SALARY UPDATED SUCCESSFULLY (ID: " + id + ")");
            } else {
                System.out.println("No employee found with ID: " + id + " to update salary.");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //Updates the age of an existing employee in the database.
    @Override
    public void updateEmployeeAge(int id, int age) {
        con = DBConnection.createDBConnection();
        // Using PreparedStatement for safe updating.
        String query = "UPDATE employee SET age = ? WHERE id = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, age); // Set the new age
            pstm.setInt(2, id);   // Set the ID for the WHERE clause

            int cnt = pstm.executeUpdate();
            if (cnt != 0) {
                System.out.println("EMPLOYEE AGE UPDATED SUCCESSFULLY (ID: " + id + ")");
            } else {
                System.out.println("No employee found with ID: " + id + " to update age.");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    //Deletes an employee record from the database based on their ID.
    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        String query="Delete from employee where id =?";
        try {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0){
                System.out.println("EMPLOYEE DETAILS DELETED SUCCESSFULLY " +id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
