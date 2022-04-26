package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeRepository er = new EmployeeRepository();


    @GetMapping("/employees")
    public String getAllEmployees(Model m) {
        List<Employee> employees = er.getAllEntities();
        m.addAttribute("employees", employees);
        return "/employees";
    }

    @GetMapping("/single-employee")
    public String getEmployee(@RequestParam int employeeID, Model m) {
        Employee employee = er.getSingleById(employeeID);
        m.addAttribute("employee", employee);
        return "/single-employee";
    }

    @GetMapping("/create-employee")
    public String createEmployee() {
        return "create-employee";
    }

    @PostMapping("/verify-employee")
    public String verifyEmployee(WebRequest employeeInfo) {
        String name = employeeInfo.getParameter("name");
        String job = employeeInfo.getParameter("job");
        int manager = Integer.parseInt(employeeInfo.getParameter("manager"));
        Date hireDate = Date.valueOf(employeeInfo.getParameter("hire-date"));
        int salary = Integer.parseInt(employeeInfo.getParameter("salary"));
        int commission = Integer.parseInt(employeeInfo.getParameter("commission"));
        int deptNumber = Integer.parseInt(employeeInfo.getParameter("department-number"));
        Employee employee = new Employee(name, job, manager, hireDate, salary, commission, deptNumber);
        er.create(employee);
        System.out.println(name + " has been created");

        return "redirect:/index";
    }
}
