package com.example.payrollsemployee.service;

import com.example.payrollsemployee.dto.EmployeeDTO;
import com.example.payrollsemployee.exception.EmpCustomException;
import com.example.payrollsemployee.model.Employee;
import com.example.payrollsemployee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService implements EmployeesService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);
    }

    public Employee updateEmployee(int id, EmployeeDTO employeeDTO) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }
        employeeData.updateEmployee(employeeDTO);
        return employeeRepo.save(employeeData);
    }

    public void deleteEmployee(int id) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData == null) {
            throw new IllegalArgumentException("User not found with ID: " + id);
        }

        employeeRepo.deleteById(id);
    }

    public void deleteAllEmployee() {

        employeeRepo.deleteAll();
    }

    public Employee getEmployeeById(int id) {

        return employeeRepo.findById(id).orElseThrow(() -> new EmpCustomException("employee with id: " + id + "not present"));
    }

    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();
    }
}
