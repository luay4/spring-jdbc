package com.example.demo.repositories;

import com.example.demo.models.Employee;
import com.example.demo.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee>{


    @Override
    public List<Employee> getAllEntities() {
        Connection con = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
                allEmployees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Connection con = DatabaseConnectionManager.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM employees WHERE id = " + id + "");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));

                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        Connection con = DatabaseConnectionManager.getConnection();
        String name = entity.getEmployeeName();
        String job = entity.getJob();
        int manager = entity.getManager();
        Date hireDate = entity.getHireDate();
        int salary = entity.getSalary();
        int commission = entity.getCommission();
        int departmentNumber = entity.getDepartmentNumber();

        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO employees (employee_name ,job ,manager ," +
                    "hiredate, salary, commission, department_number) " +
                    "VALUES ('" +  name + "','" + job + "'," + manager + ",'" + hireDate + "'," + salary + ","
                    + commission + "," + departmentNumber + ")");

            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String viewAllEmployeesByDepartmentName(String departmentName) {
        return "";
    }


}
