package com.example.payrollsemployee.service;

import com.example.payrollsemployee.dto.EmployeeDTO;
import com.example.payrollsemployee.model.Employee;

import java.util.List;


public interface EmployeesService {
    Employee addEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(int id, EmployeeDTO employeeDTO);

    void deleteEmployee(int id);

    void deleteAllEmployee();

    Employee getEmployeeById(int id);

    List<Employee> getAllEmployee();

}
