package com.example.demo.models;

import java.sql.Date;

public class Employee {

    private int id;
    private String employeeName;
    private String job;
    private int manager;
    private Date hireDate; //Data klasse
    private int salary;
    private int commission;
    private int departmentNumber;

    public Employee(int id, String employeeName, String job, int manager,
                    Date hireDate, int salary, int commission, int departmentNumber) {
        this.id = id;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public Employee(String employeeName, String job, int manager,
                    Date hireDate, int salary, int commission, int departmentNumber) {
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commission = commission;
        this.departmentNumber = departmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    @Override
    public String toString() {
        String name = employeeName.substring(0, 1) + employeeName.substring(1).toLowerCase();
        String jobTitle = job.substring(0, 1) + job.substring(1).toLowerCase();

        return "ID = " + id + ",   Name = " + name + ",   Job = " + jobTitle;
    }
}
